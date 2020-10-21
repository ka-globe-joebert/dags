
package testing.simplefileinoutjob_0_1;

import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.DataQuality;
import routines.Relational;
import routines.DataQualityDependencies;
import routines.Mathematical;
import routines.SQLike;
import routines.Numeric;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.DQTechnical;
import routines.StringHandling;
import routines.DataMasking;
import routines.TalendDate;
import routines.DqStringHandling;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: SimpleFileInOutJob Purpose: <br>
 * Description:  <br>
 * @author local@talend.com
 * @version 7.0.1.20180914_0421-patch
 * @status 
 */
public class SimpleFileInOutJob implements TalendJob {
	static {System.setProperty("TalendJob.log", "SimpleFileInOutJob.log");}
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SimpleFileInOutJob.class);

protected static void logIgnoredError(String message, Throwable cause) {
       log.error(message, cause);

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(inputFilePath != null){
				
					this.setProperty("inputFilePath", inputFilePath.toString());
				
			}
			
			if(outputFilePath != null){
				
					this.setProperty("outputFilePath", outputFilePath.toString());
				
			}
			
		}

public String inputFilePath;
public String getInputFilePath(){
	return this.inputFilePath;
}
public String outputFilePath;
public String getOutputFilePath(){
	return this.outputFilePath;
}
	}
	private ContextProperties context = new ContextProperties();
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "SimpleFileInOutJob";
	private final String projectName = "TESTING";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				SimpleFileInOutJob.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(SimpleFileInOutJob.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tFileExist_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileExist_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileDelete_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileDelete_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileOutputDelimited_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileExist_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileDelete_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
		
	





public void tFileExist_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileExist_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tFileExist_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileExist_1", false);
		start_Hash.put("tFileExist_1", System.currentTimeMillis());
		
	
	currentComponent="tFileExist_1";

	
		int tos_count_tFileExist_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFileExist_1 - "  + ("Start to work.") );
    	class BytesLimit65535_tFileExist_1{
    		public void limitLog4jByte() throws Exception{
    			
            StringBuilder log4jParamters_tFileExist_1 = new StringBuilder();
            log4jParamters_tFileExist_1.append("Parameters:");
                    log4jParamters_tFileExist_1.append("FILE_NAME" + " = " + "context.outputFilePath");
                log4jParamters_tFileExist_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFileExist_1 - "  + (log4jParamters_tFileExist_1) );
    		}
    	}
    	
        new BytesLimit65535_tFileExist_1().limitLog4jByte();

 



/**
 * [tFileExist_1 begin ] stop
 */
	
	/**
	 * [tFileExist_1 main ] start
	 */

	

	
	
	currentComponent="tFileExist_1";

	


				final StringBuffer log4jSb_tFileExist_1 = new StringBuffer();
			

java.io.File file_tFileExist_1 = new java.io.File(context.outputFilePath);
if (!file_tFileExist_1.exists()) {
    globalMap.put("tFileExist_1_EXISTS",false);
    log.info("tFileExist_1 - Directory or file : " + file_tFileExist_1.getAbsolutePath() + " doesn't exist.");
}else{
	globalMap.put("tFileExist_1_EXISTS",true);
    log.info("tFileExist_1 - Directory or file : " + file_tFileExist_1.getAbsolutePath() + " exists.");
}

globalMap.put("tFileExist_1_FILENAME",context.outputFilePath);


 


	tos_count_tFileExist_1++;

/**
 * [tFileExist_1 main ] stop
 */
	
	/**
	 * [tFileExist_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileExist_1";

	

 



/**
 * [tFileExist_1 process_data_begin ] stop
 */
	
	/**
	 * [tFileExist_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileExist_1";

	

 



/**
 * [tFileExist_1 process_data_end ] stop
 */
	
	/**
	 * [tFileExist_1 end ] start
	 */

	

	
	
	currentComponent="tFileExist_1";

	

 
                if(log.isDebugEnabled())
            log.debug("tFileExist_1 - "  + ("Done.") );

ok_Hash.put("tFileExist_1", true);
end_Hash.put("tFileExist_1", System.currentTimeMillis());

   			if (((Boolean)globalMap.get("tFileExist_1_EXISTS"))) {
   				
					if(execStat){   
   	 					runStat.updateStatOnConnection("fileExists", 0, "true");
					}
				
    			tFileDelete_1Process(globalMap);
   			}

			   
   				else{
					if(execStat){   
   	 					runStat.updateStatOnConnection("fileExists", 0, "false");
					}   	 
   				}
   			if (!((Boolean)globalMap.get("tFileExist_1_EXISTS"))) {
   				
					if(execStat){   
   	 					runStat.updateStatOnConnection("fileNotExists", 0, "true");
					}
				
    			tFileInputDelimited_1Process(globalMap);
   			}

			   
   				else{
					if(execStat){   
   	 					runStat.updateStatOnConnection("fileNotExists", 0, "false");
					}   	 
   				}



/**
 * [tFileExist_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileExist_1 finally ] start
	 */

	

	
	
	currentComponent="tFileExist_1";

	

 



/**
 * [tFileExist_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileExist_1_SUBPROCESS_STATE", 1);
	}
	

public void tFileDelete_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileDelete_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tFileDelete_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileDelete_1", false);
		start_Hash.put("tFileDelete_1", System.currentTimeMillis());
		
	
	currentComponent="tFileDelete_1";

	
		int tos_count_tFileDelete_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFileDelete_1 - "  + ("Start to work.") );
    	class BytesLimit65535_tFileDelete_1{
    		public void limitLog4jByte() throws Exception{
    			
            StringBuilder log4jParamters_tFileDelete_1 = new StringBuilder();
            log4jParamters_tFileDelete_1.append("Parameters:");
                    log4jParamters_tFileDelete_1.append("FILENAME" + " = " + "context.outputFilePath");
                log4jParamters_tFileDelete_1.append(" | ");
                    log4jParamters_tFileDelete_1.append("FAILON" + " = " + "true");
                log4jParamters_tFileDelete_1.append(" | ");
                    log4jParamters_tFileDelete_1.append("FOLDER" + " = " + "false");
                log4jParamters_tFileDelete_1.append(" | ");
                    log4jParamters_tFileDelete_1.append("FOLDER_FILE" + " = " + "false");
                log4jParamters_tFileDelete_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFileDelete_1 - "  + (log4jParamters_tFileDelete_1) );
    		}
    	}
    	
        new BytesLimit65535_tFileDelete_1().limitLog4jByte();

 



/**
 * [tFileDelete_1 begin ] stop
 */
	
	/**
	 * [tFileDelete_1 main ] start
	 */

	

	
	
	currentComponent="tFileDelete_1";

	

 

				final StringBuffer log4jSb_tFileDelete_1 = new StringBuffer();
			
class DeleteFoldertFileDelete_1{
	 /**
     * delete all the sub-files in 'file'
     * 
     * @param file
     */
	public boolean delete(java.io.File file) {
        java.io.File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                files[i].delete();
            } else if (files[i].isDirectory()) {
                if (!files[i].delete()) {
                    delete(files[i]);
                }
            }
        }
        deleteDirectory(file);
        return file.delete();
    }

    /**
     * delete all the sub-folders in 'file'
     * 
     * @param file
     */
    private void deleteDirectory(java.io.File file) {
        java.io.File[] filed = file.listFiles();
        for (int i = 0; i < filed.length; i++) {
        	if(filed[i].isDirectory()) {
            	deleteDirectory(filed[i]);
            }
            filed[i].delete();
        }
    }

}
    java.io.File file_tFileDelete_1=new java.io.File(context.outputFilePath);
    if(file_tFileDelete_1.exists()&& file_tFileDelete_1.isFile()){
    	if(file_tFileDelete_1.delete()){
    		globalMap.put("tFileDelete_1_CURRENT_STATUS", "File deleted.");
    		log.info("tFileDelete_1 - File : "+ file_tFileDelete_1.getAbsolutePath() + " is deleted.");
		}else{
			globalMap.put("tFileDelete_1_CURRENT_STATUS", "No file deleted.");
				throw new RuntimeException("File " + file_tFileDelete_1.getAbsolutePath() + " can not be deleted.");
		}
	}else{
		globalMap.put("tFileDelete_1_CURRENT_STATUS", "File does not exist or is invalid.");
			throw new RuntimeException("File " + file_tFileDelete_1.getAbsolutePath() + " does not exist or is invalid or is not a file.");
	}
	globalMap.put("tFileDelete_1_DELETE_PATH",context.outputFilePath);
    
     
 

 


	tos_count_tFileDelete_1++;

/**
 * [tFileDelete_1 main ] stop
 */
	
	/**
	 * [tFileDelete_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileDelete_1";

	

 



/**
 * [tFileDelete_1 process_data_begin ] stop
 */
	
	/**
	 * [tFileDelete_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileDelete_1";

	

 



/**
 * [tFileDelete_1 process_data_end ] stop
 */
	
	/**
	 * [tFileDelete_1 end ] start
	 */

	

	
	
	currentComponent="tFileDelete_1";

	

 
                if(log.isDebugEnabled())
            log.debug("tFileDelete_1 - "  + ("Done.") );

ok_Hash.put("tFileDelete_1", true);
end_Hash.put("tFileDelete_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tFileInputDelimited_1Process(globalMap);



/**
 * [tFileDelete_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileDelete_1 finally ] start
	 */

	

	
	
	currentComponent="tFileDelete_1";

	

 



/**
 * [tFileDelete_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileDelete_1_SUBPROCESS_STATE", 1);
	}
	


public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
    final static byte[] commonByteArrayLock_TESTING_SimpleFileInOutJob = new byte[0];
    static byte[] commonByteArray_TESTING_SimpleFileInOutJob = new byte[0];

	
			    public String name;

				public String getName () {
					return this.name;
				}
				
			    public Integer age;

				public Integer getAge () {
					return this.age;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TESTING_SimpleFileInOutJob.length) {
				if(length < 1024 && commonByteArray_TESTING_SimpleFileInOutJob.length == 0) {
   					commonByteArray_TESTING_SimpleFileInOutJob = new byte[1024];
				} else {
   					commonByteArray_TESTING_SimpleFileInOutJob = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TESTING_SimpleFileInOutJob, 0, length);
			strReturn = new String(commonByteArray_TESTING_SimpleFileInOutJob, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TESTING_SimpleFileInOutJob) {

        	try {

        		int length = 0;
		
					this.name = readString(dis);
					
						this.age = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.name,dos);
					
					// Integer
				
						writeInteger(this.age,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("name="+name);
		sb.append(",age="+String.valueOf(age));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(name == null){
        					sb.append("<null>");
        				}else{
            				sb.append(name);
            			}
            		
        			sb.append("|");
        		
        				if(age == null){
        					sb.append("<null>");
        				}else{
            				sb.append(age);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_TESTING_SimpleFileInOutJob = new byte[0];
    static byte[] commonByteArray_TESTING_SimpleFileInOutJob = new byte[0];

	
			    public String first_name;

				public String getFirst_name () {
					return this.first_name;
				}
				
			    public String last_name;

				public String getLast_name () {
					return this.last_name;
				}
				
			    public Integer age;

				public Integer getAge () {
					return this.age;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TESTING_SimpleFileInOutJob.length) {
				if(length < 1024 && commonByteArray_TESTING_SimpleFileInOutJob.length == 0) {
   					commonByteArray_TESTING_SimpleFileInOutJob = new byte[1024];
				} else {
   					commonByteArray_TESTING_SimpleFileInOutJob = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TESTING_SimpleFileInOutJob, 0, length);
			strReturn = new String(commonByteArray_TESTING_SimpleFileInOutJob, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TESTING_SimpleFileInOutJob) {

        	try {

        		int length = 0;
		
					this.first_name = readString(dis);
					
					this.last_name = readString(dis);
					
						this.age = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.first_name,dos);
					
					// String
				
						writeString(this.last_name,dos);
					
					// Integer
				
						writeInteger(this.age,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("first_name="+first_name);
		sb.append(",last_name="+last_name);
		sb.append(",age="+String.valueOf(age));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(first_name == null){
        					sb.append("<null>");
        				}else{
            				sb.append(first_name);
            			}
            		
        			sb.append("|");
        		
        				if(last_name == null){
        					sb.append("<null>");
        				}else{
            				sb.append(last_name);
            			}
            		
        			sb.append("|");
        		
        				if(age == null){
        					sb.append("<null>");
        				}else{
            				sb.append(age);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row1Struct row1 = new row1Struct();
out1Struct out1 = new out1Struct();





	
	/**
	 * [tFileOutputDelimited_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileOutputDelimited_1", false);
		start_Hash.put("tFileOutputDelimited_1", System.currentTimeMillis());
		
	
	currentComponent="tFileOutputDelimited_1";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("out1" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_tFileOutputDelimited_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFileOutputDelimited_1 - "  + ("Start to work.") );
    	class BytesLimit65535_tFileOutputDelimited_1{
    		public void limitLog4jByte() throws Exception{
    			
            StringBuilder log4jParamters_tFileOutputDelimited_1 = new StringBuilder();
            log4jParamters_tFileOutputDelimited_1.append("Parameters:");
                    log4jParamters_tFileOutputDelimited_1.append("USESTREAM" + " = " + "false");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                    log4jParamters_tFileOutputDelimited_1.append("FILENAME" + " = " + "context.outputFilePath");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                    log4jParamters_tFileOutputDelimited_1.append("ROWSEPARATOR" + " = " + "\"\\n\"");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                    log4jParamters_tFileOutputDelimited_1.append("FIELDSEPARATOR" + " = " + "\";\"");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                    log4jParamters_tFileOutputDelimited_1.append("APPEND" + " = " + "false");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                    log4jParamters_tFileOutputDelimited_1.append("INCLUDEHEADER" + " = " + "true");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                    log4jParamters_tFileOutputDelimited_1.append("COMPRESS" + " = " + "false");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                    log4jParamters_tFileOutputDelimited_1.append("ADVANCED_SEPARATOR" + " = " + "false");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                    log4jParamters_tFileOutputDelimited_1.append("CSV_OPTION" + " = " + "false");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                    log4jParamters_tFileOutputDelimited_1.append("CREATE" + " = " + "true");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                    log4jParamters_tFileOutputDelimited_1.append("SPLIT" + " = " + "false");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                    log4jParamters_tFileOutputDelimited_1.append("FLUSHONROW" + " = " + "false");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                    log4jParamters_tFileOutputDelimited_1.append("ROW_MODE" + " = " + "false");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                    log4jParamters_tFileOutputDelimited_1.append("ENCODING" + " = " + "\"ISO-8859-15\"");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                    log4jParamters_tFileOutputDelimited_1.append("DELETE_EMPTYFILE" + " = " + "false");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                    log4jParamters_tFileOutputDelimited_1.append("FILE_EXIST_EXCEPTION" + " = " + "true");
                log4jParamters_tFileOutputDelimited_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFileOutputDelimited_1 - "  + (log4jParamters_tFileOutputDelimited_1) );
    		}
    	}
    	
        new BytesLimit65535_tFileOutputDelimited_1().limitLog4jByte();

String fileName_tFileOutputDelimited_1 = "";
    fileName_tFileOutputDelimited_1 = (new java.io.File(context.outputFilePath)).getAbsolutePath().replace("\\","/");
    String fullName_tFileOutputDelimited_1 = null;
    String extension_tFileOutputDelimited_1 = null;
    String directory_tFileOutputDelimited_1 = null;
    if((fileName_tFileOutputDelimited_1.indexOf("/") != -1)) {
        if(fileName_tFileOutputDelimited_1.lastIndexOf(".") < fileName_tFileOutputDelimited_1.lastIndexOf("/")) {
            fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1;
            extension_tFileOutputDelimited_1 = "";
        } else {
            fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0, fileName_tFileOutputDelimited_1.lastIndexOf("."));
            extension_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(fileName_tFileOutputDelimited_1.lastIndexOf("."));
        }
        directory_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0, fileName_tFileOutputDelimited_1.lastIndexOf("/"));
    } else {
        if(fileName_tFileOutputDelimited_1.lastIndexOf(".") != -1) {
            fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0, fileName_tFileOutputDelimited_1.lastIndexOf("."));
            extension_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(fileName_tFileOutputDelimited_1.lastIndexOf("."));
        } else {
            fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1;
            extension_tFileOutputDelimited_1 = "";
        }
        directory_tFileOutputDelimited_1 = "";
    }
    boolean isFileGenerated_tFileOutputDelimited_1 = true;
    java.io.File filetFileOutputDelimited_1 = new java.io.File(fileName_tFileOutputDelimited_1);
    globalMap.put("tFileOutputDelimited_1_FILE_NAME",fileName_tFileOutputDelimited_1);
    if(filetFileOutputDelimited_1.exists()){
            throw new RuntimeException("The particular file \""+filetFileOutputDelimited_1.getAbsoluteFile() +
            "\" already exist. If you want to overwrite the file, please uncheck the" + 
            " \"Throw an error if the file already exist\" option in Advanced settings.");
        }
            int nb_line_tFileOutputDelimited_1 = 0;
            int splitedFileNo_tFileOutputDelimited_1 = 0;
            int currentRow_tFileOutputDelimited_1 = 0;

            final String OUT_DELIM_tFileOutputDelimited_1 = /** Start field tFileOutputDelimited_1:FIELDSEPARATOR */";"/** End field tFileOutputDelimited_1:FIELDSEPARATOR */;

            final String OUT_DELIM_ROWSEP_tFileOutputDelimited_1 = /** Start field tFileOutputDelimited_1:ROWSEPARATOR */"\n"/** End field tFileOutputDelimited_1:ROWSEPARATOR */;

                    //create directory only if not exists
                    if(directory_tFileOutputDelimited_1 != null && directory_tFileOutputDelimited_1.trim().length() != 0) {
                        java.io.File dir_tFileOutputDelimited_1 = new java.io.File(directory_tFileOutputDelimited_1);
                        if(!dir_tFileOutputDelimited_1.exists()) {
                                log.info("tFileOutputDelimited_1 - Creating directory '" + dir_tFileOutputDelimited_1.getCanonicalPath() +"'.");
                            dir_tFileOutputDelimited_1.mkdirs();
                                log.info("tFileOutputDelimited_1 - The directory '"+ dir_tFileOutputDelimited_1.getCanonicalPath() + "' has been created successfully.");
                        }
                    }

                        //routines.system.Row
                        java.io.Writer outtFileOutputDelimited_1 = null;

                        java.io.File fileToDelete_tFileOutputDelimited_1 = new java.io.File(fileName_tFileOutputDelimited_1);
                        if(fileToDelete_tFileOutputDelimited_1.exists()) {
                            fileToDelete_tFileOutputDelimited_1.delete();
                        }
                        outtFileOutputDelimited_1 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
                        new java.io.FileOutputStream(fileName_tFileOutputDelimited_1, false),"ISO-8859-15"));
                                    if(filetFileOutputDelimited_1.length()==0){
                                        outtFileOutputDelimited_1.write("name");
                                            outtFileOutputDelimited_1.write(OUT_DELIM_tFileOutputDelimited_1);
                                        outtFileOutputDelimited_1.write("age");
                                        outtFileOutputDelimited_1.write(OUT_DELIM_ROWSEP_tFileOutputDelimited_1);
                                        outtFileOutputDelimited_1.flush();
                                    }


        resourceMap.put("out_tFileOutputDelimited_1", outtFileOutputDelimited_1);
resourceMap.put("nb_line_tFileOutputDelimited_1", nb_line_tFileOutputDelimited_1);

 



/**
 * [tFileOutputDelimited_1 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("row1" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_tMap_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Start to work.") );
    	class BytesLimit65535_tMap_1{
    		public void limitLog4jByte() throws Exception{
    			
            StringBuilder log4jParamters_tMap_1 = new StringBuilder();
            log4jParamters_tMap_1.append("Parameters:");
                    log4jParamters_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
                log4jParamters_tMap_1.append(" | ");
                    log4jParamters_tMap_1.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
                log4jParamters_tMap_1.append(" | ");
                    log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
                log4jParamters_tMap_1.append(" | ");
                    log4jParamters_tMap_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
                log4jParamters_tMap_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + (log4jParamters_tMap_1) );
    		}
    	}
    	
        new BytesLimit65535_tMap_1().limitLog4jByte();




// ###############################
// # Lookup's keys initialization
		int count_row1_tMap_1 = 0;
		
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_out1_tMap_1 = 0;
				
out1Struct out1_tmp = new out1Struct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_1", false);
		start_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_1";

	
		int tos_count_tFileInputDelimited_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFileInputDelimited_1 - "  + ("Start to work.") );
    	class BytesLimit65535_tFileInputDelimited_1{
    		public void limitLog4jByte() throws Exception{
    			
            StringBuilder log4jParamters_tFileInputDelimited_1 = new StringBuilder();
            log4jParamters_tFileInputDelimited_1.append("Parameters:");
                    log4jParamters_tFileInputDelimited_1.append("FILENAME" + " = " + "context.inputFilePath");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("CSV_OPTION" + " = " + "false");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("ROWSEPARATOR" + " = " + "\"\\n\"");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("FIELDSEPARATOR" + " = " + "\";\"");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("HEADER" + " = " + "1");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("FOOTER" + " = " + "0");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("LIMIT" + " = " + "");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("REMOVE_EMPTY_ROW" + " = " + "true");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("UNCOMPRESS" + " = " + "false");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("DIE_ON_ERROR" + " = " + "false");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("ADVANCED_SEPARATOR" + " = " + "false");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("RANDOM" + " = " + "false");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("TRIMALL" + " = " + "false");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("TRIMSELECT" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("first_name")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("last_name")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("age")+"}]");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("CHECK_FIELDS_NUM" + " = " + "false");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("CHECK_DATE" + " = " + "false");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("ENCODING" + " = " + "\"ISO-8859-15\"");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("SPLITRECORD" + " = " + "false");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                    log4jParamters_tFileInputDelimited_1.append("ENABLE_DECODE" + " = " + "false");
                log4jParamters_tFileInputDelimited_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFileInputDelimited_1 - "  + (log4jParamters_tFileInputDelimited_1) );
    		}
    	}
    	
        new BytesLimit65535_tFileInputDelimited_1().limitLog4jByte();
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_1 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_1 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_1 = null;
				try{
					
						Object filename_tFileInputDelimited_1 = context.inputFilePath;
						if(filename_tFileInputDelimited_1 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_1 = 0, random_value_tFileInputDelimited_1 = -1;
			if(footer_value_tFileInputDelimited_1 >0 || random_value_tFileInputDelimited_1 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_1 = new org.talend.fileprocess.FileInputDelimited(context.inputFilePath, "ISO-8859-15",";","\n",true,1,0,-1,-1, false);
						} catch(java.lang.Exception e) {
							
								
									log.error("tFileInputDelimited_1 - " +e.getMessage());
								
								System.err.println(e.getMessage());
							
						}
					
				    
				    	log.info("tFileInputDelimited_1 - Retrieving records from the datasource.");
				    
					while (fid_tFileInputDelimited_1!=null && fid_tFileInputDelimited_1.nextRecord()) {
						rowstate_tFileInputDelimited_1.reset();
						
			    						row1 = null;			
												
									boolean whetherReject_tFileInputDelimited_1 = false;
									row1 = new row1Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_1 = 0;
				
					String temp = ""; 
				
					columnIndexWithD_tFileInputDelimited_1 = 0;
					
							row1.first_name = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 1;
					
							row1.last_name = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 2;
					
						temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						if(temp.length() > 0) {
							
								try {
								
    								row1.age = ParserUtils.parseTo_Integer(temp);
    							
    							} catch(java.lang.Exception ex_tFileInputDelimited_1) {
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
										"age", "row1", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}
    							
						} else {						
							
								
									row1.age = null;
								
							
						}
					
				
				
										
										if(rowstate_tFileInputDelimited_1.getException()!=null) {
											throw rowstate_tFileInputDelimited_1.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
			        					whetherReject_tFileInputDelimited_1 = true;
			        					
												log.error("tFileInputDelimited_1 - " +e.getMessage());
											
			                					System.err.println(e.getMessage());
			                					row1 = null;
			                				
			    					}
								
			log.debug("tFileInputDelimited_1 - Retrieving the record " + fid_tFileInputDelimited_1.getRowNumber() + ".");
		

 



/**
 * [tFileInputDelimited_1 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_1 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 


	tos_count_tFileInputDelimited_1++;

/**
 * [tFileInputDelimited_1 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 



/**
 * [tFileInputDelimited_1 process_data_begin ] stop
 */
// Start of branch "row1"
if(row1 != null) { 



	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

			//row1
			//row1


			
				if(execStat){
					runStat.updateStatOnConnection("row1"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		
        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

out1 = null;


// # Output table : 'out1'
count_out1_tMap_1++;

out1_tmp.name = row1.first_name + " " +  row1.last_name ;
out1_tmp.age = row1.age ;
out1 = out1_tmp;
log.debug("tMap_1 - Outputting the record " + count_out1_tMap_1 + " of the output table 'out1'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "out1"
if(out1 != null) { 



	
	/**
	 * [tFileOutputDelimited_1 main ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_1";

	

			//out1
			//out1


			
				if(execStat){
					runStat.updateStatOnConnection("out1"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("out1 - " + (out1==null? "": out1.toLogString()));
    			}
    		


                    StringBuilder sb_tFileOutputDelimited_1 = new StringBuilder();
                            if(out1.name != null) {
                        sb_tFileOutputDelimited_1.append(
                            out1.name
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(out1.age != null) {
                        sb_tFileOutputDelimited_1.append(
                            out1.age
                        );
                            }
                    sb_tFileOutputDelimited_1.append(OUT_DELIM_ROWSEP_tFileOutputDelimited_1);


                    nb_line_tFileOutputDelimited_1++;
                    resourceMap.put("nb_line_tFileOutputDelimited_1", nb_line_tFileOutputDelimited_1);

                        outtFileOutputDelimited_1.write(sb_tFileOutputDelimited_1.toString());
                        log.debug("tFileOutputDelimited_1 - Writing the record " + nb_line_tFileOutputDelimited_1 + ".");




 


	tos_count_tFileOutputDelimited_1++;

/**
 * [tFileOutputDelimited_1 main ] stop
 */
	
	/**
	 * [tFileOutputDelimited_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_1";

	

 



/**
 * [tFileOutputDelimited_1 process_data_begin ] stop
 */
	
	/**
	 * [tFileOutputDelimited_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_1";

	

 



/**
 * [tFileOutputDelimited_1 process_data_end ] stop
 */

} // End of branch "out1"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */

} // End of branch "row1"




	
	/**
	 * [tFileInputDelimited_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 



/**
 * [tFileInputDelimited_1 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_1 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	



            }
            }finally{
                if(!((Object)(context.inputFilePath) instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_1!=null){
                		fid_tFileInputDelimited_1.close();
                	}
                }
                if(fid_tFileInputDelimited_1!=null){
                	globalMap.put("tFileInputDelimited_1_NB_LINE", fid_tFileInputDelimited_1.getRowNumber());
					
						log.info("tFileInputDelimited_1 - Retrieved records count: "+ fid_tFileInputDelimited_1.getRowNumber() + ".");
					
                }
			}
			  

 
                if(log.isDebugEnabled())
            log.debug("tFileInputDelimited_1 - "  + ("Done.") );

ok_Hash.put("tFileInputDelimited_1", true);
end_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());




/**
 * [tFileInputDelimited_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'out1': " + count_out1_tMap_1 + ".");





			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("row1"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Done.") );

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tFileOutputDelimited_1 end ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_1";

	



		
			
					if(outtFileOutputDelimited_1!=null) {
						outtFileOutputDelimited_1.flush();
						outtFileOutputDelimited_1.close();
					}
				
				globalMap.put("tFileOutputDelimited_1_NB_LINE",nb_line_tFileOutputDelimited_1);
				globalMap.put("tFileOutputDelimited_1_FILE_NAME",fileName_tFileOutputDelimited_1);
			
		
		
		resourceMap.put("finish_tFileOutputDelimited_1", true);
	
				log.debug("tFileOutputDelimited_1 - Written records count: " + nb_line_tFileOutputDelimited_1 + " .");
			

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("out1"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("tFileOutputDelimited_1 - "  + ("Done.") );

ok_Hash.put("tFileOutputDelimited_1", true);
end_Hash.put("tFileOutputDelimited_1", System.currentTimeMillis());




/**
 * [tFileOutputDelimited_1 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_1 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 



/**
 * [tFileInputDelimited_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tFileOutputDelimited_1 finally ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_1";

	


		if(resourceMap.get("finish_tFileOutputDelimited_1") == null){ 
			
				
						java.io.Writer outtFileOutputDelimited_1 = (java.io.Writer)resourceMap.get("out_tFileOutputDelimited_1");
						if(outtFileOutputDelimited_1!=null) {
							outtFileOutputDelimited_1.flush();
							outtFileOutputDelimited_1.close();
						}
					
				
			
		}
	

 



/**
 * [tFileOutputDelimited_1 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    private PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final SimpleFileInOutJob SimpleFileInOutJobClass = new SimpleFileInOutJob();

        int exitCode = SimpleFileInOutJobClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'SimpleFileInOutJob' - Done.");
	        }

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";

        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }

	        if(!"".equals(log4jLevel)){
				if("trace".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.TRACE);
				}else if("debug".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.DEBUG);
				}else if("info".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.INFO);
				}else if("warn".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.WARN);
				}else if("error".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.ERROR);
				}else if("fatal".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.FATAL);
				}else if ("off".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.OFF);
				}
				org.apache.log4j.Logger.getRootLogger().setLevel(log.getLevel());
    	    }
        	log.info("TalendJob: 'SimpleFileInOutJob' - Start.");
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = SimpleFileInOutJob.class.getClassLoader().getResourceAsStream("testing/simplefileinoutjob_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = SimpleFileInOutJob.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                //defaultProps is in order to keep the original context value
                defaultProps.load(inContext);
                inContext.close();
                context = new ContextProperties(defaultProps);
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
				    context.setContextType("inputFilePath", "id_String");
				
                context.inputFilePath=(String) context.getProperty("inputFilePath");
				    context.setContextType("outputFilePath", "id_String");
				
                context.outputFilePath=(String) context.getProperty("outputFilePath");
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }


        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("inputFilePath")) {
                context.inputFilePath = (String) parentContextMap.get("inputFilePath");
            }if (parentContextMap.containsKey("outputFilePath")) {
                context.outputFilePath = (String) parentContextMap.get("outputFilePath");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();




this.globalResumeTicket = true;//to run tPreJob




this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tFileExist_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileExist_1) {
globalMap.put("tFileExist_1_SUBPROCESS_STATE", -1);

e_tFileExist_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : SimpleFileInOutJob");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;
    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {


    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();







        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        }else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		}

    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     73860 characters generated by Talend Big Data Platform 
 *     on the March 5, 2020 3:21:15 PM CST
 ************************************************************************************************/