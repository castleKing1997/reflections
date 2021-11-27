package org.reflections;

public class DemoUsageService {
    public MySuperClass o1 = new @DemoAnnotation(value="Test") MySuperClass() {
        @Override
        public String getClassName() {
            return "AnonymousClass";
        }
    };

    public void doSomething() {
        MySuperClass o2 = new @DemoAnnotation(value="Test") MySuperClass() {
            @Override
            public String getClassName() {
                return "AnonymousClass";
            }
        };
    }
}