package io.infrastructor.core.utils

class NodeUtils {
    
    static int randomPort() {
        ServerSocket serverSocket = new ServerSocket(0);
        def port = serverSocket.getLocalPort();
        serverSocket.close()
        return port
    }
}

