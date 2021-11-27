```mermaid
classDiagram
      Scanner <.. Configuration
      URL <.. Configuration
      ClassLoader <.. Configuration
      Predicate <.. Configuration
      Configuration <|.. ConfigurationBuilder
      Predicate o-- FilterBuilder
      Predicate <|.. Matcher
      Matcher <|-- Include
      Matcher <|-- Exclude
      ClasspathHelper <.. ConfigurationBuilder
      class Predicate{
        +test(T t)
      }
      class Configuration{
      	+getScanners()
      	+getUrls()
      	+getInputsFilter()
      	+getClassLoaders()
      	+isParaller()
      	+shouldExpandSuperTypes()
      }
      class Scanner{
        scan(ClassFile classFile)
        scan(Vfs.File file)
      }
      class ConfigurationBuilder{
      	+build(Object... params)
      	+forPackage(String pkg, ClassLoader... classLoaders)
      	+addUrls(URL... urls)
      	+addScanners(Scanner... scanners)
      }
      class FilterBuilder{
        -List<Predicate<String>> chain
        +includePackage(String value)
      }
      class ClasspathHelper{
      	+forPackage(String name, ClassLoader... classLoaders)
      	+forClass(Class<?> aClass, ClassLoader... classLoaders)
      	+forClassLoader(ClassLoader... classLoaders)
      }


```

```mermaid
classDiagram
	  class NameHelper{
        +toName(Class<?> type)
        +forClass(String typeName, ClassLoader... loaders)
      }
```

```mermaid
classDiagram
      Scanner <|.. AbstractScanner
      AbstractScanner <|-- SubTypesScanner
      AbstractScanner <|-- TypeAnnotationsScanner
      AbstractScanner <|-- xxxxxxxxxxx
      AbstractScanner <|-- MethodAnnotationsScanner
      AbstractScanner <|-- FieldAnnotationsScanner
      class Scanner{
        scan(ClassFile classFile)
        scan(Vfs.File file)
      }
```

```mermaid
classDiagram
	  ReflectionUtilsPredicates <|-- ReflectionUtils
	  class Reflections{
        +Reflections(Configuration configuration)
        +expandSuperTypes(Map<String, Set<String>> subTypesStore, Map<String, Set<String>> typesAnnotatedStore)
        +get(QueryFunction<Store, T> query)
        +getTypesAnnotatedWith(Class<? extends Annotation> annotation)
        ~scan()
      }
      class ReflectionUtilsPredicates{
      	+get(QueryFunction<C, T> function)
      }
      
```

```mermaid
classDiagram
	MethodInfo <.. ClassFile
	class ClassFile{
        int major;
        int minor;
        ConstPool constPool;
        int thisClass;
        int accessFlags;
        int superClass;
        int[] interfaces;
        List<FieldInfo> fields;
        List<MethodInfo> methods;
        List<AttributeInfo> attributes;
        String thisclassname;
        String[] cachedInterfaces;
        String cachedSuperclass;
	}
```





- Annotated
  - FieldsAnnotated
  - MethodAnnotated
  - MethodAnnotated
  - ConstructorsAnnotated
  - TypesAnnotated
- Signature
  - ConstructorsSignature
  - MethodsSignature
- Parameter
  - ConstructorsParameter
  - MethodsParameter
- Scanner
  - MenberUsageScanner
  - MethodParameterNamesScanner
- Subtypes
- MethodsReturn
- Resources