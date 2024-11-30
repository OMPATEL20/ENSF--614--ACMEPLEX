package com.acmeplex.model;



//import java.sql.Timestamp;

//public class Seat {
//  private int row;
//  private int number;
//  private boolean isAvailable;
//  private int movieId; // ID of the movie being shown
//  private int theaterId; // ID of the theater
//  private Timestamp showTime; // Showtime for the movie

//  // Constructor
//  public Seat(int row, int number, boolean isAvailable, int movieId, int theaterId, Timestamp showTime) {
//      this.row = row;
//      this.number = number;
//      this.isAvailable = isAvailable;
//      this.movieId = movieId;
//      this.theaterId = theaterId;
//      this.showTime = showTime;
//  }

//  // Getters and Setters
//  public int getRow() {
//      return row;
//  }

//  public void setRow(int row) {
//      this.row = row;
//  }

//  public int getNumber() {
//      return number;
//  }

//  public void setNumber(int number) {
//      this.number = number;
//  }

//  public boolean isAvailable() {
//      return isAvailable;
//  }

//  public void setAvailable(boolean available) {
//      isAvailable = available;
//  }

//  public int getMovieId() {
//      return movieId;
//  }

//  public void setMovieId(int movieId) {
//      this.movieId = movieId;
//  }

//  public int getTheaterId() {
//      return theaterId;
//  }

//  public void setTheaterId(int theaterId) {
//      this.theaterId = theaterId;
//  }

//  public Timestamp getShowTime() {
//      return showTime;
//  }

//  public void setShowTime(Timestamp showTime) {
//      this.showTime = showTime;
//  }

//  @Override
//  public String toString() {
//      return "Seat{" +
//              "row=" + row +
//              ", number=" + number +
//              ", isAvailable=" + isAvailable +
//              ", movieId=" + movieId +
//              ", theaterId=" + theaterId +
//              ", showTime=" + showTime +
//              '}';
//  }
//}


//import jakarta.persistence.*;

//@Entity
//@Table(name = "seats")
//public class Seat {

//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Long id;

//  @Column(name = "row_number", nullable = false)
//  private int row;

//  @Column(name = "seat_number", nullable = false)
//  private int number;

//  @Column(name = "is_available", nullable = false)
//  private boolean isAvailable;

//  @ManyToOne
//  @JoinColumn(name = "showtime_id", nullable = false)
//  private Showtime showtime; // Relates seats to a specific showtime

//  // Constructors
//  public Seat() {
//  }

//  public Seat(int row, int number, boolean isAvailable, Showtime showtime) {
//      this.row = row;
//      this.number = number;
//      this.isAvailable = isAvailable;
//      this.showtime = showtime;
//  }

//  // Getters and Setters
//  public Long getId() {
//      return id;
//  }

//  public void setId(Long id) {
//      this.id = id;
//  }

//  public int getRow() {
//      return row;
//  }

//  public void setRow(int row) {
//      this.row = row;
//  }

//  public int getNumber() {
//      return number;
//  }

//  public void setNumber(int number) {
//      this.number = number;
//  }

//  public boolean isAvailable() {
//      return isAvailable;
//  }

//  public void setAvailable(boolean isAvailable) {
//      this.isAvailable = isAvailable;
//  }

//  public Showtime getShowtime() {
//      return showtime;
//  }

//  public void setShowtime(Showtime showtime) {
//      this.showtime = showtime;
//  }
//}




import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int seatId;

 @Column(name = "rowNum", nullable = false)
 private int rowNum;

 @Column(name = "seatNum", nullable = false)
 private int seatNum;

 @Column(name = "isAvailable", nullable = false)
 private boolean isAvailable;

 public Seat() {
 }

 public Seat(int row, int number, boolean isAvailable) {
     this.rowNum = row;
     this.seatNum = number;
     this.isAvailable = isAvailable;
 }

 // Getters and Setters
 public int getId() {
     return seatId;
 }

 public int getRow() {
     return rowNum;
 }

 public void setRow(int row) {
     this.rowNum = row;
 }

 public int getNumber() {
     return seatNum;
 }

 public void setNumber(int number) {
     this.seatNum = number;
 }

 public boolean isAvailable() {
     return isAvailable;
 }

 public void setAvailable(boolean available) {
     isAvailable = available;
 }


}


