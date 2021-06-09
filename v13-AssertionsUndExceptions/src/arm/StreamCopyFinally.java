package arm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamCopyFinally {

//	public static void main(String[] args) throws IOException {
//		InputStream in = System.in;
//		OutputStream out = System.out;
//		try {
//			for (int code = in.read(); code >= 0; code = in.read()) {
//				out.write(code);
//			}
//		} finally {
//			in.close();
//			out.close();
//		}
//	}

	public static void main(String[] args) throws IOException {
		try (InputStream in = System.in; OutputStream out = System.out) {
			int code = in.read();
			while (code > 0) {
				out.write(code);
				code = in.read();
			}
		}
	}
}
