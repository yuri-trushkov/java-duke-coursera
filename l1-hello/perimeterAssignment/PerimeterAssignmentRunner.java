import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
  
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPoints = 0;
        for (Point currPt : s.getPoints()) {
          numPoints++;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double averageLength = 0.0, perimeter = 0.0;
        int numPoints = 0;
        
        perimeter = getPerimeter(s);
        numPoints = getNumPoints(s);
        averageLength = perimeter / numPoints;

        return averageLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double currSideLength = 0;
        double maxSideLength = 0;
        
        for (Point currPt : s.getPoints()) {
            currSideLength = currPt.distance(prevPt);
            if (currSideLength > maxSideLength) {
                maxSideLength = currSideLength;
            }
            prevPt = currPt; 
        }
        return maxSideLength;
    }

    public double getLargestX(Shape s) {
        // Put code here
        
        double maxX = 0.0;
        double currX = 0.0;
        for (Point currPt : s.getPoints()) {
            currX = currPt.getX();
            if (currX > maxX) {maxX = currX;}
        }
        
        return maxX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        
        DirectoryResource dr = new DirectoryResource();
        double maxPer = 0.0, currPer = 0.0;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);    
            currPer = getPerimeter(s);
            if (maxPer < currPer) {maxPer = currPer;}
        }
        return maxPer;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        
        DirectoryResource dr = new DirectoryResource();
        double maxPer = 0.0, currPer = 0.0;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);    
            currPer = getPerimeter(s);
            if (maxPer < currPer) {
                maxPer = currPer;
                temp = f;
            }
        }
        return temp.getName();
    }
    

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        int numPoints = getNumPoints(s);
        System.out.println("numPoints = " + numPoints);
        
        double averageLength = getAverageLength(s);
        System.out.println("averageLength = " + averageLength);
        
        double largestSide = getLargestSide(s);
        System.out.println("largestSide = " + largestSide);
        
        double largestX = getLargestX(s);
        System.out.println("largestX = " + largestX);
    }
    
    public void testLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPer = getLargestPerimeterMultipleFiles();
        System.out.println("largestPer = " + largestPer);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String largestPerimeterFile = getFileWithLargestPerimeter();
        System.out.println("largestPerimeterFile = " + largestPerimeterFile);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        
        pr.testLargestPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
        pr.testPerimeter();
    }
}
