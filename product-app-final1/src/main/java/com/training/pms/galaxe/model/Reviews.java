package com.training.pms.galaxe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
//@ToString

public class Reviews {

	private int reviewId;
	private String comments;
	private int rating;

}

//this is one time process
//https://projectlombok.org/downloads/lombok.jar
//after downloading jar files go to downloads
//type cmd
//C:\Users\tufail\Downloads>java -jar lombok.jar
//install/update
//QuickInstaller