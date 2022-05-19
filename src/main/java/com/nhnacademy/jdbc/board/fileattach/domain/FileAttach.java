package com.nhnacademy.jdbc.board.fileattach.domain;

import java.util.Date;
import lombok.Getter;

@Getter
public class FileAttach {
    private String fileName;
    private int boardNo;
    private Date uploadDatetime;

    public FileAttach(String fileName, int boardNo, Date uploadDatetime) {
        this.fileName = fileName;
        this.boardNo = boardNo;
        this.uploadDatetime = uploadDatetime;
    }

    @Override
    public String toString() {
        return "FileAttach{" +
            "fileName='" + fileName + '\'' +
            ", boardNo=" + boardNo +
            ", uploadDatetime=" + uploadDatetime +
            '}';
    }
}
