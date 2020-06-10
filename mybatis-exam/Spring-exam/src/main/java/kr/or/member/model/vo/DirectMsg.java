package kr.or.member.model.vo;

public class DirectMsg {
	private int msgNo;
	private String msgSender;
	private String msgReceiver;
	private String msgContent;
	private int checkMsg;
	private String msgDate;
	public DirectMsg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DirectMsg(int msgNo, String msgSender, String msgReceiver, String msgContent, int checkMsg, String msgDate) {
		super();
		this.msgNo = msgNo;
		this.msgSender = msgSender;
		this.msgReceiver = msgReceiver;
		this.msgContent = msgContent;
		this.checkMsg = checkMsg;
		this.msgDate = msgDate;
	}
	public int getMsgNo() {
		return msgNo;
	}
	public void setMsgNo(int msgNo) {
		this.msgNo = msgNo;
	}
	public String getMsgSender() {
		return msgSender;
	}
	public void setMsgSender(String msgSender) {
		this.msgSender = msgSender;
	}
	public String getMsgReceiver() {
		return msgReceiver;
	}
	public void setMsgReceiver(String msgReceiver) {
		this.msgReceiver = msgReceiver;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public int getCheckMsg() {
		return checkMsg;
	}
	public void setCheckMsg(int checkMsg) {
		this.checkMsg = checkMsg;
	}
	public String getMsgDate() {
		return msgDate;
	}
	public void setMsgDate(String msgDate) {
		this.msgDate = msgDate;
	}
	
	
}
