package io.infrastructor.core.logging.status

import static io.infrastructor.core.logging.ConsoleLogger.addStatusLogger
import static io.infrastructor.core.logging.ConsoleLogger.removeStatusLogger

class TextStatusLogger {
	
    def text
    def listener = {}
    
    String statusLine() {
        text
    }
    
    void setStatus(def text) {
        this.text = text
        listener()
    }
    
    static def withTextStatus(Closure closure) {
        withTextStatus('', closure)
    }
    
    static def withTextStatus(String initial, Closure closure) {
        def status = new TextStatusLogger(text: initial)
        try {
            addStatusLogger status
            return closure(status.&setStatus)
        } finally {
            removeStatusLogger status
        }
    }
}

