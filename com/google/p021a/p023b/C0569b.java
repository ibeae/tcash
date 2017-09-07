package com.google.p021a.p023b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class C0569b {
    static final Type[] f602a = new Type[0];

    private static final class C0566a implements Serializable, GenericArrayType {
        private final Type f596a;

        public C0566a(Type type) {
            this.f596a = C0569b.m1147d(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C0569b.m1141a((Type) this, (GenericArrayType) obj);
        }

        public Type getGenericComponentType() {
            return this.f596a;
        }

        public int hashCode() {
            return this.f596a.hashCode();
        }

        public String toString() {
            return C0569b.m1149f(this.f596a) + "[]";
        }
    }

    private static final class C0567b implements Serializable, ParameterizedType {
        private final Type f597a;
        private final Type f598b;
        private final Type[] f599c;

        public C0567b(Type type, Type type2, Type... typeArr) {
            boolean z = true;
            int i = 0;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z2 = type != null || cls.getEnclosingClass() == null;
                C0565a.m1130a(z2);
                if (type != null && cls.getEnclosingClass() == null) {
                    z = false;
                }
                C0565a.m1130a(z);
            }
            this.f597a = type == null ? null : C0569b.m1147d(type);
            this.f598b = C0569b.m1147d(type2);
            this.f599c = (Type[]) typeArr.clone();
            while (i < this.f599c.length) {
                C0565a.m1129a(this.f599c[i]);
                C0569b.m1152i(this.f599c[i]);
                this.f599c[i] = C0569b.m1147d(this.f599c[i]);
                i++;
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C0569b.m1141a((Type) this, (ParameterizedType) obj);
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.f599c.clone();
        }

        public Type getOwnerType() {
            return this.f597a;
        }

        public Type getRawType() {
            return this.f598b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f599c) ^ this.f598b.hashCode()) ^ C0569b.m1142b(this.f597a);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder((this.f599c.length + 1) * 30);
            stringBuilder.append(C0569b.m1149f(this.f598b));
            if (this.f599c.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append("<").append(C0569b.m1149f(this.f599c[0]));
            for (int i = 1; i < this.f599c.length; i++) {
                stringBuilder.append(", ").append(C0569b.m1149f(this.f599c[i]));
            }
            return stringBuilder.append(">").toString();
        }
    }

    private static final class C0568c implements Serializable, WildcardType {
        private final Type f600a;
        private final Type f601b;

        public C0568c(Type[] typeArr, Type[] typeArr2) {
            boolean z = true;
            C0565a.m1130a(typeArr2.length <= 1);
            C0565a.m1130a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                C0565a.m1129a(typeArr2[0]);
                C0569b.m1152i(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    z = false;
                }
                C0565a.m1130a(z);
                this.f601b = C0569b.m1147d(typeArr2[0]);
                this.f600a = Object.class;
                return;
            }
            C0565a.m1129a(typeArr[0]);
            C0569b.m1152i(typeArr[0]);
            this.f601b = null;
            this.f600a = C0569b.m1147d(typeArr[0]);
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C0569b.m1141a((Type) this, (WildcardType) obj);
        }

        public Type[] getLowerBounds() {
            if (this.f601b == null) {
                return C0569b.f602a;
            }
            return new Type[]{this.f601b};
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.f600a};
        }

        public int hashCode() {
            return (this.f601b != null ? this.f601b.hashCode() + 31 : 1) ^ (this.f600a.hashCode() + 31);
        }

        public String toString() {
            return this.f601b != null ? "? super " + C0569b.m1149f(this.f601b) : this.f600a == Object.class ? "?" : "? extends " + C0569b.m1149f(this.f600a);
        }
    }

    private static int m1132a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> m1133a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        return genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
    }

    public static GenericArrayType m1134a(Type type) {
        return new C0566a(type);
    }

    public static ParameterizedType m1135a(Type type, Type type2, Type... typeArr) {
        return new C0567b(type, type2, typeArr);
    }

    public static Type m1136a(Type type, Class<?> cls) {
        Type b = C0569b.m1143b(type, cls, Collection.class);
        if (b instanceof WildcardType) {
            b = ((WildcardType) b).getUpperBounds()[0];
        }
        return b instanceof ParameterizedType ? ((ParameterizedType) b).getActualTypeArguments()[0] : Object.class;
    }

    static Type m1137a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return C0569b.m1137a(cls.getGenericInterfaces()[i], interfaces[i], (Class) cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            Class cls3;
            while (cls3 != Object.class) {
                Class superclass = cls3.getSuperclass();
                if (superclass == cls2) {
                    return cls3.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return C0569b.m1137a(cls3.getGenericSuperclass(), superclass, (Class) cls2);
                }
                cls3 = superclass;
            }
        }
        return cls2;
    }

    public static Type m1138a(Type type, Class<?> cls, Type type2) {
        Type type3 = type2;
        while (type3 instanceof TypeVariable) {
            type3 = (TypeVariable) type3;
            type2 = C0569b.m1139a(type, (Class) cls, (TypeVariable) type3);
            if (type2 == type3) {
                return type2;
            }
            type3 = type2;
        }
        Type componentType;
        Type a;
        if ((type3 instanceof Class) && ((Class) type3).isArray()) {
            Class cls2 = (Class) type3;
            componentType = cls2.getComponentType();
            a = C0569b.m1138a(type, (Class) cls, componentType);
            return componentType != a ? C0569b.m1134a(a) : cls2;
        } else if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            componentType = genericArrayType.getGenericComponentType();
            a = C0569b.m1138a(type, (Class) cls, componentType);
            return componentType != a ? C0569b.m1134a(a) : genericArrayType;
        } else if (type3 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            componentType = parameterizedType.getOwnerType();
            Type a2 = C0569b.m1138a(type, (Class) cls, componentType);
            int i = a2 != componentType ? 1 : 0;
            r4 = parameterizedType.getActualTypeArguments();
            int length = r4.length;
            int i2 = i;
            r1 = r4;
            for (int i3 = 0; i3 < length; i3++) {
                Type a3 = C0569b.m1138a(type, (Class) cls, r1[i3]);
                if (a3 != r1[i3]) {
                    if (i2 == 0) {
                        r1 = (Type[]) r1.clone();
                        i2 = 1;
                    }
                    r1[i3] = a3;
                }
            }
            return i2 != 0 ? C0569b.m1135a(a2, parameterizedType.getRawType(), r1) : parameterizedType;
        } else if (!(type3 instanceof WildcardType)) {
            return type3;
        } else {
            WildcardType wildcardType = (WildcardType) type3;
            r1 = wildcardType.getLowerBounds();
            r4 = wildcardType.getUpperBounds();
            if (r1.length == 1) {
                a = C0569b.m1138a(type, (Class) cls, r1[0]);
                return a != r1[0] ? C0569b.m1146c(a) : wildcardType;
            } else if (r4.length != 1) {
                return wildcardType;
            } else {
                componentType = C0569b.m1138a(type, (Class) cls, r4[0]);
                return componentType != r4[0] ? C0569b.m1144b(componentType) : wildcardType;
            }
        }
    }

    static Type m1139a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class a = C0569b.m1133a((TypeVariable) typeVariable);
        if (a == null) {
            return typeVariable;
        }
        Type a2 = C0569b.m1137a(type, (Class) cls, a);
        if (!(a2 instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) a2).getActualTypeArguments()[C0569b.m1132a(a.getTypeParameters(), (Object) typeVariable)];
    }

    static boolean m1140a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean m1141a(Type type, Type type2) {
        boolean z = true;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (!(C0569b.m1140a(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments()))) {
                z = false;
            }
            return z;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return C0569b.m1141a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!(Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds()))) {
                z = false;
            }
            return z;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (!(typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName()))) {
                z = false;
            }
            return z;
        }
    }

    private static int m1142b(Object obj) {
        return obj != null ? obj.hashCode() : 0;
    }

    static Type m1143b(Type type, Class<?> cls, Class<?> cls2) {
        C0565a.m1130a(cls2.isAssignableFrom(cls));
        return C0569b.m1138a(type, (Class) cls, C0569b.m1137a(type, (Class) cls, (Class) cls2));
    }

    public static WildcardType m1144b(Type type) {
        return new C0568c(new Type[]{type}, f602a);
    }

    public static Type[] m1145b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type b = C0569b.m1143b(type, cls, Map.class);
        if (b instanceof ParameterizedType) {
            return ((ParameterizedType) b).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static WildcardType m1146c(Type type) {
        return new C0568c(new Type[]{Object.class}, new Type[]{type});
    }

    public static Type m1147d(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new C0566a(C0569b.m1147d(cls.getComponentType())) : cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C0567b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new C0566a(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new C0568c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    public static Class<?> m1148e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            C0565a.m1130a(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(C0569b.m1148e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return C0569b.m1148e(((WildcardType) type).getUpperBounds()[0]);
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }
    }

    public static String m1149f(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Type m1150g(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    private static void m1152i(Type type) {
        boolean z = ((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true;
        C0565a.m1130a(z);
    }
}
