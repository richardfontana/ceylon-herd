package util;

import java.io.File;

import play.Logger;
import play.mvc.Http.Request;

public class Util {
    
    // postgres default limit for varchar
    public static final int VARCHAR_SIZE = 255;
    // artificial limit, since for @Lob String, there's no limit (text in DB)
    public static final int TEXT_SIZE = 8192;
    
	public static File getUploadDir(Long id) {
		return new File("uploads"+File.separator+id);
	}

	public static File getRepoDir() {
		return new File("repo");
	}

    public static void logSecurityAction(String message, Object... params) {
        Object[] newParams = new Object[params.length+1];
        System.arraycopy(params, 0, newParams, 1, params.length);
        newParams[0] = Request.current().remoteAddress;
        Logger.info("[SECURITY: %s]: "+message, newParams);
    }
}
