// Yixiao Li
// 11/25/18
// PlaceInformation.java

// This class stores information about a place on Earth. The information
// of a place is specified using name, address, tag, latitude and longitude.

public class PlaceInformation {
   
   private String name;       // name of a location
   private String address;    // address of a location
   private String tag;        // tag representing a location
   private GeoLocation location; // GeoLocation object of a location
   
   // constructs a place information object with given name, address,
   // tag, latitude and longitude
   //
   // String name - the name of a location
   // String address - the address of a location
   // String tag - the tag representing a location
   // double latitude - latitude of a location
   // double longitude - longitude of a location
   public PlaceInformation(String name, String address, String tag, 
                           double latitude, double longitude) {
      this.name = name;
      this.address = address;
      this.tag = tag;
      // latitude and longitude is stored in a geo location object
      this.location = new GeoLocation(latitude, longitude);
   }
   
   // returns the name of this place information
   public String getName() {
      return name;
   }
   
   // returns the address of this place information
   public String getAddress() {
      return address;
   }
   
   // returns the tag of this place information
   public String getTag() {
      return tag;
   }
   
   // returns a string representation of this place information
   public String toString() {
      return name + " (" + location + ")";
   }
   
   // returns a geo location object representing the same location
   // of this place information object
   public GeoLocation getLocation() {
      return location;
   }
   
   // returns the distance in miles between this geo location and
   // the given other geo location
   public double distanceFrom(GeoLocation spot) {
      return location.distanceFrom(spot);
   }
}
