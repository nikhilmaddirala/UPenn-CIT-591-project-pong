
/**
 * This class instantiates vectors and performs vector algebra.
 *
 */
public class Vector2 {

	double x, y;

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * This method scales the vector by a given constant.
	 * 
	 * @param c The constant scalar.
	 * @return The scaled vector.
	 */
	public Vector2 times(double c) {
		return new Vector2(x * c, y * c);
	}

	/**
	 * This method subtracts another vector from the this vector.
	 * 
	 * @param v2 The vector to be subtracted (vector 2).
	 * @return The result of the vector subtraction (this vector minus vector 2).
	 */
	public Vector2 minus(Vector2 v2) {
		return new Vector2(this.x - v2.x, this.y - v2.y);
	}

	/**
	 * This method adds another vector to this vector.
	 * 
	 * @param v2 The vector to be added (vector 2).
	 * @return The result of vector addition (this vector plus vector 2).
	 */
	public Vector2 plus(Vector2 v2) {
		return new Vector2(this.x + v2.x, this.y + v2.y);
	}

	/**
	 * This method returns the length of the vector.
	 * 
	 * @return The length of the vector.
	 */
	public double length() {
		return Math.sqrt(x * x + y * y);
	}

	/**
	 * This method calculates the distance between this vector and another vector.
	 * 
	 * @param v2 The vector from which the distance is to be calculated.
	 * @return The distance between this vector and vector 2.
	 */
	public double distanceTo(Vector2 v2) {
		Vector2 diff = this.minus(v2);
		return diff.length();
	}

	/**
	 * This method scales the vector by the length of the vector.
	 * 
	 * @return The normalized vector.
	 */
	public Vector2 normalized() {
		double len = this.length();
		return new Vector2(this.x / len, this.y / len);
	}

	/**
	 * This method calculates the dot product of this vector with another vector.
	 * 
	 * @param v2 The other vector.
	 * @return The dot product (this vector dot vector 2).
	 */
	public double dot(Vector2 v2) {
		return this.x * v2.x + this.y * v2.y;
	}

	/**
	 * This method returns the reflection of this vector against a normalized
	 * vector.
	 * 
	 * @param normal The normalized vector reflected against.
	 * @return The resultant reflection vector.
	 */
	public Vector2 reflect(Vector2 normal) {
		// r = d - 2 * dot(d, n) * n
		double dotprod = this.dot(normal);
		Vector2 result = normal.times(dotprod);
		result = result.times(2.0);
		return this.minus(result);
	}

}
