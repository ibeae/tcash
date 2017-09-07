package com.facebook.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public interface OpenGraphObject extends GraphObject {

    public static final class Factory {
        public static <T extends OpenGraphObject> T createForPost(Class<T> cls, String str) {
            return createForPost(cls, str, null, null, null, null);
        }

        public static <T extends OpenGraphObject> T createForPost(Class<T> cls, String str, String str2, String str3, String str4, String str5) {
            OpenGraphObject openGraphObject = (OpenGraphObject) com.facebook.model.GraphObject.Factory.create((Class) cls);
            if (str != null) {
                openGraphObject.setType(str);
            }
            if (str2 != null) {
                openGraphObject.setTitle(str2);
            }
            if (str3 != null) {
                openGraphObject.setImageUrls(Arrays.asList(new String[]{str3}));
            }
            if (str4 != null) {
                openGraphObject.setUrl(str4);
            }
            if (str5 != null) {
                openGraphObject.setDescription(str5);
            }
            openGraphObject.setCreateObject(true);
            openGraphObject.setData(com.facebook.model.GraphObject.Factory.create());
            return openGraphObject;
        }

        public static OpenGraphObject createForPost(String str) {
            return createForPost(OpenGraphObject.class, str);
        }
    }

    GraphObject getApplication();

    GraphObjectList<GraphObject> getAudio();

    @PropertyName("fbsdk:create_object")
    boolean getCreateObject();

    Date getCreatedTime();

    GraphObject getData();

    String getDescription();

    String getDeterminer();

    String getId();

    GraphObjectList<GraphObject> getImage();

    boolean getIsScraped();

    String getPostActionId();

    List<String> getSeeAlso();

    String getSiteName();

    String getTitle();

    String getType();

    Date getUpdatedTime();

    String getUrl();

    GraphObjectList<GraphObject> getVideo();

    void setApplication(GraphObject graphObject);

    void setAudio(GraphObjectList<GraphObject> graphObjectList);

    @PropertyName("fbsdk:create_object")
    void setCreateObject(boolean z);

    void setCreatedTime(Date date);

    void setData(GraphObject graphObject);

    void setDescription(String str);

    void setDeterminer(String str);

    void setId(String str);

    void setImage(GraphObjectList<GraphObject> graphObjectList);

    @CreateGraphObject("url")
    @PropertyName("image")
    void setImageUrls(List<String> list);

    void setIsScraped(boolean z);

    void setPostActionId(String str);

    void setSeeAlso(List<String> list);

    void setSiteName(String str);

    void setTitle(String str);

    void setType(String str);

    void setUpdatedTime(Date date);

    void setUrl(String str);

    void setVideo(GraphObjectList<GraphObject> graphObjectList);
}
