import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

enum Planeta {
  MERCURY (3.303e+23, 2.4397e6),
  VENUS   (4.869e+24, 6.0518e6),
  EARTH   (5.976e+24, 6.37814e6),
  MARS    (6.421e+23, 3.3972e6),
  JUPITER (1.9e+27, 7.1492e7),
  SATURN  (5.688e+26, 6.0268e7),
  URANUS  (8.686e+25, 2.5559e7),
  NEPTUNE (1.024e+26, 2.4746e7);
  private final double mass;   // in kilograms
  private final double radius; // in meters
  Planeta(double mass, double radius) {
    this.mass = mass;
    this.radius = radius;
  }
  
  public static final double G = 6.67300E-11 ;
  
  double forcaGravitacional() {
    double fg = (G*this.mass)/(this.radius*this.radius); 
    return fg;
  }
  double pesoSuperficie(double otherMass) {
    double fg = this.forcaGravitacional();
    return (otherMass*fg)*0.102012;
  }
}