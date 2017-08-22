/*Name: Susan Zhao
 * PennKey: suzhao
 * Recitation: 216
 * 
 * Execution: java NBody
 * 
 * Simulates the interactions of celestial bodies
 */

public class NBody {
    public static void main(String[] args) {
        
        // declare the three variables and assign to args
        double simulationTime = Double.parseDouble(args[0]);
        double timeStep = Double.parseDouble(args[1]);
        String filename = args[2];
        
        // creates a variable inStream to read from the file
        In inStream = new In(filename); 
        
        // variables
        int numParticles = inStream.readInt();
        double radius = inStream.readDouble();
        
        // create arrays from file with length numParticles
        double[] m = new double[numParticles];
        double[] px = new double[numParticles];
        double[] py = new double[numParticles];
        double[] vx = new double[numParticles];
        double[] vy = new double[numParticles];
        String[] img = new String[numParticles]; 
        
        // create new arrays to calculate distance, force, acceleration
        double[] delX = new double[numParticles]; 
        double[] delY = new double[numParticles];
        double[] distance = new double[numParticles];
        double[] force = new double[numParticles];
        double[] forceX = new double[numParticles];
        double[] forceY = new double[numParticles]; 
        double[] netForceX = new double[numParticles];
        double[] netForceY = new double[numParticles];
        double[] accelerationX = new double[numParticles];
        double[] accelerationY = new double[numParticles];
        
        // loop through all the values in the file
        for (int i = 0; i < numParticles; i++) {
            m[i] = inStream.readDouble();
            px[i] = inStream.readDouble();
            py[i] = inStream.readDouble();
            vx[i] = inStream.readDouble();
            vy[i] = inStream.readDouble();
            img[i] = inStream.readString();
        }
        
        // System.out.println(numParticles); debugging
        
        // set the window
        PennDraw.setXscale(-radius, radius);
        PennDraw.setYscale(-radius, radius);
        
        PennDraw.enableAnimation(30);
        StdAudio.play("2001.mid");
        
        for (int x = 0; x < simulationTime; x += timeStep) {        
            PennDraw.picture(0, 0, "starfield.jpg");
            
            for (int i = 0; i < numParticles; i++) {
                //value of gravity
                double gravity = 6.67e-11; 
                
                //reset net Force to compute next step
                netForceX[i] = 0;
                netForceY[i] = 0;
                
                // compute distance and force between two celestial bodies 
                // this includes the summation of the forces acting on one body
                for (int j = 0; j < numParticles; j++) {
                    
                    if (j == i) {
                        continue;
                    }
                    else {
                        delX[j] = px[j] - px[i];
                        delY[j] = py[j] - py[i];
                        distance[j] = Math.sqrt(delX[j] * delX[j] + delY[j] * 
                                                delY[j]);
                        
                        // compute Forces
                        force[j] = ((gravity * m[i]) / (distance[j] * 
                                                distance[j])) * m[j];
                        forceX[j] = force[j] * delX[j] / distance[j];
                        forceY[j] = force[j] * delY[j] / distance[j]; 
                        
                        netForceX[i] += forceX[j];
                        netForceY[i] += forceY[j];
                    }
                }
                // computing acceleration
                accelerationX[i] = netForceX[i] / m[i];
                accelerationY[i] = netForceY[i] / m[i];           
                
                // computing velocity
                vx[i] += timeStep * accelerationX[i];
                vy[i] += timeStep * accelerationY[i];
            }
            // updating position
            for (int i = 0; i < numParticles; i++) { 
                px[i] += timeStep * vx[i];
                py[i] += timeStep * vy[i];
                
                PennDraw.picture(px[i], py[i], img[i]);                
            }
            PennDraw.advance();
        }
        
      System.out.printf("%d\n", numParticles);
        System.out.printf("%.2e\n", radius);
        for (int i = 0; i < numParticles; i++) {
            System.out.printf("%12.5e %12.5e %12.5e %12.5e %12.5e %12s\n", 
                              m[i], px[i], py[i], vx[i], vy[i], img[i]);
        } 
    }
}



        