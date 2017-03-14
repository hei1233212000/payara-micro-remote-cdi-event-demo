## Reproduce steps
1. cd to the payara-micro-remote-cdi-event-demo folder
2. package first
>$ mvn clean package
3. start 3 instances by execute the following command
>$ mvn exec:exec
4. execute
>$ curl http://localhost:8080/payara-micro-remote-cdi-event-demo/?msg=clustered-msg  
5. check the console
6. you would find that the sender instance would NOT receive the event
7. curl http://localhost:8080/payara-micro-remote-cdi-event-demo/loop-back?msg=loop-back-clustered-msg  
8. check the console  
9. you would now see the sender instance will receive the event..