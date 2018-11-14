This project causes 16189 implicit searches from macros and I'm trying to find a way to reduce duplicate macro expansions.

Following the idea laid out in [this blog post](https://www.scala-lang.org/blog/2018/06/04/scalac-profiling.html) I've created a [flamegraph](implicit_search_event.svg) of the implicit search. The computation of ToValue and ToSchema for our basic types is repeated hundreds of time.

For instance, these are the highest offenders of "Implicit search by type":

```
[info]   "scala.reflect.Manifest[test.Event8]" -> 238,                                                       
[info]   "scala.reflect.Manifest[test.Event9 :+: shapeless.CNil]" -> 238,                                                                                                                      
[info]   "scala.reflect.api.Universe#TypeTag[test.Event7 :+: test.Event8 :+: test.Event9 :+: shapeless.CNil]" -> 240,                                                                         
[info]   "scala.reflect.api.Universe#TypeTag[test.Event6]" -> 274,                                                                                                                             
[info]   "scala.reflect.Manifest[shapeless.CNil]" -> 285,                                                                                                                                      
[info]   "scala.reflect.Manifest[test.Event9]" -> 285,                                                                                                                                         
[info]   "scala.reflect.api.Universe#TypeTag[test.Event8 :+: test.Event9 :+: shapeless.CNil]" -> 287,                                                                                          
[info]   "scala.reflect.api.Universe#TypeTag[test.Event7]" -> 325,                                                                                                                             
[info]   "scala.reflect.api.Universe#TypeTag[test.Event9 :+: shapeless.CNil]" -> 338,                          
[info]   "scala.reflect.api.Universe#TypeTag[test.Event8]" -> 380,                                                                                                                
[info]   "shapeless.Lazy[com.sksamuel.avro4s.ToSchema[test.OrgId]]" -> 397,                                                                                                                   
[info]   "scala.reflect.api.Universe#TypeTag[shapeless.CNil]" -> 439,                                                                                                   
[info]   "shapeless.Lazy[com.sksamuel.avro4s.ToSchema[test.ProjectId]]" -> 442,           
[info]   "scala.reflect.api.Universe#TypeTag[test.Event9]" -> 580                       
```

