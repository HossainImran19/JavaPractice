# Template

### Map <T, U>

<details>
    <summary>Travers</summary>

```java
   Map<? super Object, String> errors = new HashMap<>();
        
   String string = "error";
   InputStream inputStream = InputStream.nullInputStream();
   errors.put(inputStream, "This is inputstream");
   errors.put(string, "This is String");
            
   for (var entry : map.entrySet()) {
       System.out.println(entry.getKey() + "/" + entry.getValue());
   }
```

</details>
