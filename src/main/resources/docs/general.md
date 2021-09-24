# General

### Base64 converter
echo -n <string> | base64


### Naming convention to write tests
void <method-name>_<condition>_<expected-result>


### Public apis
https://github.com/public-apis/public-apis


### WebSockets
- Persistent connection between a client and server. WebSockets provide a bidirectional, full-duplex communications channel that operates over HTTP through a single TCP/IP socket connection. At its core, the WebSocket protocol facilitates message passing between a client and server.
- Useful tool for building web applications that need to provide these instant, real-time updates and communication
- Consider using WebSockets for instantaneous data without the browser refresh (social feeds, multiplayer games, collaborative editing, chats, ...)


### SOP and CORS
- server-side configurations that clients decide to enforce or not. 
  - Browsers enforce it to prevent attacks
  - Development tools (like Postman) don't care about it
- Same-origin policy
  - restricts cross-origin interaction between documents, scripts or media files from one origin to a different origin
  - necessary to prevent Cross-Site Request Forgery (CSRF) - visiting a malicious website that could load the content of the correct site 
- CORS 
  - HTTP-header based mechanism that allows a server to indicate any other origins (domain, scheme or port) than its own from which a browser should permit loading of resources
  - allows servers to specify trusted origins to be used in cross-origin requests
  - can be 
    - Simple - HTTP method GET, POST or HEAD; Content-Type text/plain, application/x-www-form-urlencoded or multipart/form-data
    - Preflight - others - used to check that the server will permit the actual request

### OpenAPI and Swagger
- standard format to define the structure and syntax of REST APIs
