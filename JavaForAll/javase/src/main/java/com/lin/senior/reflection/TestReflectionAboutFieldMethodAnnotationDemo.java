package com.lin.senior.reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @program: javase
 * @description: 测试反射获取运行类的属性 方法 注解等
 * @author: linsz
 * @create: 2022-06-13 13:33
 **/
public class TestReflectionAboutFieldMethodAnnotationDemo {

    @Test
    public void testGetField() throws NoSuchFieldException {
        Class<Human> humanClass = Human.class;
        //1. getFields() 只能获取 自身类和父类的public方法
        Field[] fields = humanClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("-------------");
        //2. getDeclaredFields() 只能获取自身所有权限的属性
        Field[] declaredFields = humanClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.print(declaredField + "\t\t");
            System.out.print(Modifier.toString(declaredField.getModifiers()) + "\t\t");
            System.out.println(declaredField.getType() + "\t\t");
            System.out.println(declaredField.getName());
        }
        System.out.println("==================");
        //3.getField()该方法只能获取public 类型的属性
        Field desc = humanClass.getField("desc");
        System.out.println(desc);

        System.out.println("------------------");
        //4. 该方法不能获取非public的其他属性
//        Field name = humanClass.getField("name");
//        name.setAccessible(true);
//        System.out.println(name);

        Field name = humanClass.getDeclaredField("name");
        System.out.println(name);
    }

    @Test
    public void testMethod1() {
        Class<Human> humanClass = Human.class;
        //1. 能获取子类和父类的public修饰的方法，如果该方法在子类被重写，则不显示父类的该方法
        Method[] methods = humanClass.getMethods();
        for (Method method : methods) {
            System.out.print(method + "\t\t");

            System.out.println();
        }

    }

    @Test
    public void testMethod2() {
        Class<Human> humanClass = Human.class;
        Method[] declaredMethods = humanClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.print(declaredMethod + "\t\t");

            int modifiers = declaredMethod.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t\t");

            System.out.print(declaredMethod.getReturnType() + "\t\t");

            Annotation[] declaredAnnotations = declaredMethod.getDeclaredAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                System.out.print(declaredAnnotation + "\t\t");
            }

            Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.print(exceptionType + "\t\t");
            }

            TypeVariable<Method>[] typeParameters = declaredMethod.getTypeParameters();
            for (TypeVariable<Method> typeParameter : typeParameters) {
                System.out.print(typeParameter + "\t\t");
            }

            Parameter[] parameters = declaredMethod.getParameters();
            for (Parameter parameter : parameters) {
                System.out.print(parameter + "\t\t");
            }
            System.out.println(declaredMethod.getParameterCount());

            System.out.println();
        }
    }

    @Test
    public void testOthers() {
        Class<Human> humanClass = Human.class;
        //1. getPackage()
        System.out.println(humanClass.getPackage().getName());
        //2. 得到该类的接口 getInterfaces()
        for (Class<?> anInterface : humanClass.getInterfaces()) {
            System.out.println(anInterface);
        }
        //3. 得到父类
        System.out.println(humanClass.getSuperclass());

        //4.得到父类的泛型
        System.out.println(humanClass.getGenericSuperclass());
        // System.out.println(humanClass.getGenericSuperclass().getTypeName());
        Type genericSuperclass = humanClass.getGenericSuperclass();
        //5.得到父类泛型的参数
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument.getTypeName());
        }
    }


}
