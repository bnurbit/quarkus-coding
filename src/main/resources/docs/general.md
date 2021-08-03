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


### CORS - cross-origin resource sharing
- HTTP-header based mechanism that allows a server to indicate any other origins (domain, scheme or port) than its own from which a browser should permit loading of resources.
- also relies on a mechanism by which browsers make a “preflight” request to the server hosting the cross-origin resource, in order to check that the server will permit the actual request. In that preflight, the browser sends headers that indicate the HTTP method and headers that will be used in the actual request.

