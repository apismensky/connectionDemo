Entity Manager connection issue
===============================

This project reproduces the issue with play! EntityManager.
The application has one api method which does a simple call like
`SELECT 'rs' FROM DUAL`
and one API test that executes calls this service method several times
To see connection leak problem run
`play test`
and you will see exception like

`java.sql.SQLException: Timed out waiting for a free available connection.
at com.jolbox.bonecp.DefaultConnectionStrategy.getConnectionInternal(DefaultConnectionStrategy.java:88) ~[bonecp.jar:na]  `

Then change line 16 in HealthController.scala to
`val em = JPA.em()`
and test will pass