package kr.or.board.model.vo;

public class Board {
	private int boardNo;
	private int boardType;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private int readCount;
	private String regDate;
	private String filename;
	private String filepath;
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int boardNo, int boardType, String boardWriter, String boardTitle, String boardContent, int readCount,
			String regDate, String filename, String filepath) {
		super();
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.readCount = readCount;
		this.regDate = regDate;
		this.filename = filename;
		this.filepath = filepath;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getBoardType() {
		return boardType;
	}
	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	
}
