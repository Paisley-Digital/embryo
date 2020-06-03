**Welcome to our genesis microservice, use it as a quickstarter for new ms**

---

## Clone your repo

You’ll start by editing your microservice README.

---

## Custom content 

Copy & Paste the content of this repo in your new project

1. Search for **'genesis'** and replace it with the **name** of the microservice
2. Maybe you'll need to change some files like 'DummyApi' to your microservice name.
3. Replace dummy content with your content
4. Ask in slack for adding the needed configuration in kubernetes  
5. Make a Pull Request
6. Deploy your branch using http://ci.paisley.digital
7. If behaviour tests are ok, your branch will be promoted to production and then merged.
8. I recommend you to use a TDD or ATDD approach. We have good quality gates >70% test coverage ;)

---

## The code

Next, you’ll need to understand the main rules of the code

1. APIController implements DummyAPI interface.
2. The **client** package contains client for other web services.
3. In clients, you can use **RibbonClient** for internal traffic between our own microservices.
4. Use **dto** package for reponse/request clients with another services
5. Use **entities** to crud entities in database using JPA **repositories**
6. Use **mappers** to move data between layers. model to dto or dto to model or entity to dto.
7. We use database as code. You can use **liquibase** master for adding your own sql to be executed on deploy.
8. You must **test** all your methods in service layers, using mockbeans for clients and repositories you will find and example in DummyServiceTest.java.
9. You must cover all your methods in controller layers, using spring cloud contracts, you will find and example in getDummy.groovy
10. You must replace this README content with your own microservice readme.

---