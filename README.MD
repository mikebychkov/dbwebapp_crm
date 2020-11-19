Spring MVC Application example.

Used Postgres SQL for database storage, Hibernate as ORM with c3p0 connection pool.

Added logging support using Spring AOP.

Added REST API using Spring REST:
    
    add customer - POST ./api/customers/ 
    get customer list - GET ./api/customers/
    get customer by id - GET ./api/customers/{id}
    update customer - PUT ./api/customers/
    delete customer - DELETE ./api/customers/{id}