package src.problems.leetcode.easy;

public class RectangleOverlap {
  class Point {
    public int x;
    public int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  class Rectangle {
    public Point bottomLeft;
    public Point topRight;

    Rectangle(Point bottomLeft, Point topRight) {
      this.bottomLeft = bottomLeft;
      this.topRight = topRight;
    }
  }

  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    Rectangle rect1 = new Rectangle(new Point(rec1[0], rec1[1]), new Point(rec1[2], rec1[3]));
    Rectangle rect2 = new Rectangle(new Point(rec2[0], rec2[1]), new Point(rec2[2], rec2[3]));

    return rect1.topRight.x > rect2.bottomLeft.x && rect1.bottomLeft.x < rect2.topRight.x
        && rect1.topRight.y > rect2.bottomLeft.y && rect2.topRight.y > rect1.bottomLeft.y;
  }
}
