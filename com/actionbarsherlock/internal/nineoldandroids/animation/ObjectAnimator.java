package com.actionbarsherlock.internal.nineoldandroids.animation;

public final class ObjectAnimator extends ValueAnimator {
    private static final boolean DBG = false;
    private String mPropertyName;
    private Object mTarget;

    private ObjectAnimator(Object obj, String str) {
        this.mTarget = obj;
        setPropertyName(str);
    }

    public static ObjectAnimator ofFloat(Object obj, String str, float... fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setFloatValues(fArr);
        return objectAnimator;
    }

    public static ObjectAnimator ofInt(Object obj, String str, int... iArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setIntValues(iArr);
        return objectAnimator;
    }

    public static ObjectAnimator ofObject(Object obj, String str, TypeEvaluator typeEvaluator, Object... objArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setObjectValues(objArr);
        objectAnimator.setEvaluator(typeEvaluator);
        return objectAnimator;
    }

    public static ObjectAnimator ofPropertyValuesHolder(Object obj, PropertyValuesHolder... propertyValuesHolderArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.mTarget = obj;
        objectAnimator.setValues(propertyValuesHolderArr);
        return objectAnimator;
    }

    void animateValue(float f) {
        super.animateValue(f);
        for (PropertyValuesHolder animatedValue : this.mValues) {
            animatedValue.setAnimatedValue(this.mTarget);
        }
    }

    public ObjectAnimator clone() {
        return (ObjectAnimator) super.clone();
    }

    public String getPropertyName() {
        return this.mPropertyName;
    }

    public Object getTarget() {
        return this.mTarget;
    }

    void initAnimation() {
        if (!this.mInitialized) {
            for (PropertyValuesHolder propertyValuesHolder : this.mValues) {
                propertyValuesHolder.setupSetterAndGetter(this.mTarget);
            }
            super.initAnimation();
        }
    }

    public ObjectAnimator setDuration(long j) {
        super.setDuration(j);
        return this;
    }

    public void setFloatValues(float... fArr) {
        if (this.mValues == null || this.mValues.length == 0) {
            setValues(PropertyValuesHolder.ofFloat(this.mPropertyName, fArr));
            return;
        }
        super.setFloatValues(fArr);
    }

    public void setIntValues(int... iArr) {
        if (this.mValues == null || this.mValues.length == 0) {
            setValues(PropertyValuesHolder.ofInt(this.mPropertyName, iArr));
            return;
        }
        super.setIntValues(iArr);
    }

    public void setObjectValues(Object... objArr) {
        if (this.mValues == null || this.mValues.length == 0) {
            setValues(PropertyValuesHolder.ofObject(this.mPropertyName, (TypeEvaluator) null, objArr));
            return;
        }
        super.setObjectValues(objArr);
    }

    public void setPropertyName(String str) {
        if (this.mValues != null) {
            PropertyValuesHolder propertyValuesHolder = this.mValues[0];
            String propertyName = propertyValuesHolder.getPropertyName();
            propertyValuesHolder.setPropertyName(str);
            this.mValuesMap.remove(propertyName);
            this.mValuesMap.put(str, propertyValuesHolder);
        }
        this.mPropertyName = str;
        this.mInitialized = false;
    }

    public void setTarget(Object obj) {
        if (this.mTarget != obj) {
            Object obj2 = this.mTarget;
            this.mTarget = obj;
            if (obj2 == null || obj == null || obj2.getClass() != obj.getClass()) {
                this.mInitialized = false;
            }
        }
    }

    public void setupEndValues() {
        initAnimation();
        for (PropertyValuesHolder propertyValuesHolder : this.mValues) {
            propertyValuesHolder.setupEndValue(this.mTarget);
        }
    }

    public void setupStartValues() {
        initAnimation();
        for (PropertyValuesHolder propertyValuesHolder : this.mValues) {
            propertyValuesHolder.setupStartValue(this.mTarget);
        }
    }

    public void start() {
        super.start();
    }

    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.mTarget;
        if (this.mValues != null) {
            for (PropertyValuesHolder propertyValuesHolder : this.mValues) {
                str = str + "\n    " + propertyValuesHolder.toString();
            }
        }
        return str;
    }
}
