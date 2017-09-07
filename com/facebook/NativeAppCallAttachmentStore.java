package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public final class NativeAppCallAttachmentStore implements AttachmentDataSource {
    static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
    private static final String TAG = NativeAppCallAttachmentStore.class.getName();
    private static File attachmentsDirectory;

    interface ProcessAttachment<T> {
        void processAttachment(T t, File file);
    }

    class C03971 implements ProcessAttachment<Bitmap> {
        C03971() {
        }

        public void processAttachment(Bitmap bitmap, File file) {
            Closeable fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
            } finally {
                Utility.closeQuietly(fileOutputStream);
            }
        }
    }

    class C03982 implements ProcessAttachment<File> {
        C03982() {
        }

        public void processAttachment(File file, File file2) {
            Throwable th;
            Closeable fileOutputStream = new FileOutputStream(file2);
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            Utility.closeQuietly(fileOutputStream);
                            Utility.closeQuietly(fileInputStream);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Utility.closeQuietly(fileOutputStream);
                    Utility.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                Utility.closeQuietly(fileOutputStream);
                Utility.closeQuietly(fileInputStream);
                throw th;
            }
        }
    }

    private <T> void addAttachments(Context context, UUID uuid, Map<String, T> map, ProcessAttachment<T> processAttachment) {
        if (map.size() != 0) {
            if (attachmentsDirectory == null) {
                cleanupAllAttachments(context);
            }
            ensureAttachmentsDirectoryExists(context);
            List<File> arrayList = new ArrayList();
            try {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    File attachmentFile = getAttachmentFile(uuid, str, true);
                    arrayList.add(attachmentFile);
                    processAttachment.processAttachment(value, attachmentFile);
                }
            } catch (Throwable e) {
                Throwable th = e;
                Log.e(TAG, "Got unexpected exception:" + th);
                for (File delete : arrayList) {
                    try {
                        delete.delete();
                    } catch (Exception e2) {
                    }
                }
                throw new FacebookException(th);
            }
        }
    }

    static synchronized File getAttachmentsDirectory(Context context) {
        File file;
        synchronized (NativeAppCallAttachmentStore.class) {
            if (attachmentsDirectory == null) {
                attachmentsDirectory = new File(context.getCacheDir(), ATTACHMENTS_DIR_NAME);
            }
            file = attachmentsDirectory;
        }
        return file;
    }

    public void addAttachmentFilesForCall(Context context, UUID uuid, Map<String, File> map) {
        Validate.notNull(context, "context");
        Validate.notNull(uuid, "callId");
        Validate.containsNoNulls(map.values(), "imageAttachmentFiles");
        Validate.containsNoNullOrEmpty(map.keySet(), "imageAttachmentFiles");
        addAttachments(context, uuid, map, new C03982());
    }

    public void addAttachmentsForCall(Context context, UUID uuid, Map<String, Bitmap> map) {
        Validate.notNull(context, "context");
        Validate.notNull(uuid, "callId");
        Validate.containsNoNulls(map.values(), "imageAttachments");
        Validate.containsNoNullOrEmpty(map.keySet(), "imageAttachments");
        addAttachments(context, uuid, map, new C03971());
    }

    void cleanupAllAttachments(Context context) {
        Utility.deleteDirectory(getAttachmentsDirectory(context));
    }

    public void cleanupAttachmentsForCall(Context context, UUID uuid) {
        Utility.deleteDirectory(getAttachmentsDirectoryForCall(uuid, false));
    }

    File ensureAttachmentsDirectoryExists(Context context) {
        File attachmentsDirectory = getAttachmentsDirectory(context);
        attachmentsDirectory.mkdirs();
        return attachmentsDirectory;
    }

    File getAttachmentFile(UUID uuid, String str, boolean z) {
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(uuid, z);
        if (attachmentsDirectoryForCall == null) {
            return null;
        }
        try {
            return new File(attachmentsDirectoryForCall, URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    File getAttachmentsDirectoryForCall(UUID uuid, boolean z) {
        if (attachmentsDirectory == null) {
            return null;
        }
        File file = new File(attachmentsDirectory, uuid.toString());
        if (!z || file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    public File openAttachment(UUID uuid, String str) {
        if (Utility.isNullOrEmpty(str) || uuid == null) {
            throw new FileNotFoundException();
        }
        try {
            return getAttachmentFile(uuid, str, false);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }
}
