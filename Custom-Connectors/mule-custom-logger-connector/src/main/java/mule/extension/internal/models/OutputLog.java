package mule.extension.internal.models;


public class OutputLog {

	private String timestamp;
	private String correlationID;
	private Application application;
	private Audit audit;
	
	public OutputLog() {
	}

	public OutputLog(String timestamp, String correlationID, Application application, Audit audit) {
		super();
		this.timestamp = timestamp;
		this.correlationID = correlationID;
		this.application = application;
		this.audit = audit;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getCorrelationID() {
		return correlationID;
	}

	public void setCorrelationID(String correlationID) {
		this.correlationID = correlationID;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	
}
