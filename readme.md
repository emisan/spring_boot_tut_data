curl or use installed Postman or even if IntelliJ ultimate is available use build-in HttpClient to fire up following HTTP-requests

POST http://localhost:8080/api/content
body:
{
"id": 2,
"title": "Another article",
"description": "2nd article",
"status": "IN_PROGRESS",
"contentType": "ARTICLE",
"created": "2023-07-17T18:00:58.1488071",
"updated": null,
"url": ""
}

GET http://localhost:8080/api/content

GET http://localhost:8080/api/content/1

GET http://localhost:8080/api/content/2

DELETE http://localhost:8080/api/content/delete/2