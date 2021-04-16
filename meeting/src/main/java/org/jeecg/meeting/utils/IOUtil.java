package org.jeecg.meeting.utils;//IOUtil
import java.io.Closeable;
import java.io.IOException;
public class IOUtil {

     public static void close(Closeable... closeables) throws IOException {
                 if (closeables != null) {
            for (Closeable closeable : closeables) {
                                if (closeable != null) {
                                   closeable.close();
                                 }
                          }
                  }
          }

           public static void closeQuietly(Closeable... closeables) {
                try {
                         close(closeables);
                     } catch (IOException e) {
                    }
             }
}


