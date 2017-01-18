using System;
using static System.Console;
using System.IO;
using System.Linq;

namespace Bme121.Pa3
{
    /// <StudentPlan>Biomedical Engineering</StudentPlan>
    /// <StudentDept>Department of Systems Design Engineering</StudentDept>
    /// <StudentInst>University of Waterloo</StudentInst>
    /// <StudentName>D'Souza, Heather</StudentName>
    /// <StudentUserID>hkdsouza</StudentUserID>
    /// <StudentAcknowledgements>
    /// I declare that, except as acknowledged below, this is my original work.
    /// Acknowledged contributions of others:
    /// </StudentAcknowledgements>
    
    static partial class Program
    {
        static void Main( )
        {
            string inputFile  = @"21_training.csv";
            //string outputFile = @"21_training_edges.csv";
            int height;  // image height (number of rows)
            int width;  // image width (number of columns)
            Color[ , ] inImage = new Color [584, 565];
            Color[ , ] outImage = new Color [584, 565];
           
            
            // Read the input image from its csv file.
            FileStream inFile = new FileStream(inputFile, FileMode.Open, FileAccess.Read);
			StreamReader inSR = new StreamReader(inFile);
			
			height = int.Parse(inSR.ReadLine()); 
			width = int.Parse(inSR.ReadLine())*4;
			
			for (int i=0; i<height; i++) 
			{
				
				int a = 0; //to track the index of Color [ , ] inImage;
				string[ ] numbers = inSR.ReadLine( ).Split( ",".ToCharArray( ) );	
			    for(int j = 0; j<width-3; j++)
				{
					if ((j)%4 == 0 && j<width-3)
					{
						inImage [i, a] = Color.FromArgb(int.Parse(numbers[j]), int.Parse(numbers [j+1]), int.Parse(numbers[j+2]), int.Parse(numbers[j+3]));
						a++;
					}
				}
            }
            
            
            // Generate the output image using Kirsch edge detection.
          
            for (int i=0; i<inImage.GetLength(0); i++)
            {
				for (int j=0; j<inImage.GetLength(1); j++)
				{
					if (!(i==0||i==583||j==0||j==564))
					{
						outImage [i,j] = GetKirschEdgeValue(inImage[i-1, j-1], inImage[i-1, j], inImage[i-1,j+1], inImage[i,j-1], inImage[i,j], inImage[i,j+1], inImage[i+1,j-1], inImage[i+1,j], inImage[i+1,j+1]);
					}
					else 
					{
						outImage [i,j] = inImage [i,j];
					}
				}
			}
			
            inSR.Dispose();
            inFile.Dispose();
      
            // Write the output image to its csv file.
            FileStream outFile = new FileStream (@"newPicture.csv", FileMode.Create, FileAccess.Write);
            StreamWriter outSW = new StreamWriter (outFile);
            
            outSW.WriteLine(height);
            outSW.WriteLine(width/4);
            for (int i=0; i<height; i++)
            {
				for (int j=0; j<width/4; j++)
				{
					outSW.Write("{0},{1},{2},{3},", outImage[i,j].A, outImage[i,j].R, outImage[i,j].G, outImage[i,j].B);
				}
				
				outSW.WriteLine();
			}
            
        }
        
        // This method computes the Kirsch edge-detection value for pixel color
        // at the centre location given the centre-location pixel color and the
        // colors of its eight neighbours.  These are numbered as follows.
        // The resulting color has the same alpha as the centre pixel, 
        // and Kirsch edge-detection intensities which are computed separately
        // for each of the red, green, and blue components using its eight neighbours.
        // c1 c2 c3
        // c4    c5
        // c6 c7 c8
        static Color GetKirschEdgeValue( 
            Color c1, Color c2,     Color c3, 
            Color c4, Color centre, Color c5, 
            Color c6, Color c7,     Color c8 )
        {
			int alphaValue = centre.A;
            int redValue = GetKirschEdgeValue(c1.R, c2.R, c3.R, c4.R, c5.R, c6.R, c7.R, c8.R);
            
            //if statements for each color component (except alpha) to avoid overflowing the representation of each color component
            if (redValue<0)
            {
				redValue=0;
			}
			else if (redValue>255)
			{
				redValue=255;
			}
			else
			{
				
			}
			
			int greenValue = GetKirschEdgeValue(c1.G, c2.G, c3.G, c4.G, c5.G, c6.G, c7.G, c8.G);
			
			if (greenValue<0)
            {
				greenValue=0;
			}
			else if (greenValue>255)
			{
				greenValue=255;
			}
			else
			{
				
			}
			
			int blueValue = GetKirschEdgeValue(c1.B, c2.B, c3.B, c4.B, c5.B, c6.B, c7.B, c8.B);
			
			if (blueValue<0)
            {
				blueValue=0;
			}
			else if (blueValue>255)
			{
				blueValue=255;
			}
			else
			{
				
			}
			
			//new color object for each pixel in the output image
			Color final = Color.FromArgb(alphaValue,redValue,greenValue,blueValue);;
			return final;
        }
        
        // This method computes the Kirsch edge-detection value for pixel intensity
        // at the centre location given the pixel intensities of the eight neighbours.
        // These are numbered as follows.
        // i1 i2 i3
        // i4    i5
        // i6 i7 i8
        static int GetKirschEdgeValue( 
            int i1, int i2, int i3, 
            int i4,         int i5, 
            int i6, int i7, int i8 )
        {
            //convolution (sum of each numbr in the operator multiplied by the associated pixel intensity)
            int sum1, sum2, sum3, sum4, sum5,sum6,sum7,sum8;
            sum1 = i1*5 + i2*5 + i3*5 + i4*(-3) + i5*(-3) + i6*(-3) + i7*(-3) + i8*(-3);
            sum2 = i1*(-3) + i2*5 + i3*5 + i4*(-3) + i5*5 + i6*(-3) + i7*(-3) + i8*(-3);
            sum3 = i1*(-3) + i2*(-3) + i3*(-3) + i4*(-3) + i5*5 + i6*(-3) + i7*5 + i8*5;
            sum4 = i1*(-3) + i2*(-3) + i3*5 + i4*(-3) + i5*5 + i6*(-3) + i7*(-3) + i8*5;
            sum5 = i1*(-3) + i2*(-3) + i3*(-3) + i4*(-3) + i5*(-3) + i6*5 + i7*5 + i8*5;
            sum6 = i1*(-3) + i2*(-3) + i3*(-3) + i4*5 + i5*(-3) + i6*5 + i7*5 + i8*(-3);
            sum7 = i1*5 + i2*(-3) + i3*(-3) + i4*5 + i5*(-3) + i6*5 + i7*(-3) + i8*(-3);
            sum8 = i1*5 + i2*5 + i3*(-3) + i4*5 + i5*(-3) + i6*(-3) + i7*(-3) + i8*(-3);
            
            //return the maximum sum
            return Math.Max(sum1, Math.Max(sum2, Math.Max(sum3, Math.Max(sum4, Math.Max(sum5, Math.Max(sum6, Math.Max(sum7, sum8)))))));
        }
    }
    
    // Implementation of part of System.Drawing.Color.
    // This is needed because .Net Core doesn't seem to include the assembly 
    // containing System.Drawing.Color even though docs.microsoft.com claims 
    // it is part of the .Net Core API.
    struct Color
    {
        int alpha;
        int red;
        int green;
        int blue;
        
        public int A { get { return alpha; } }
        public int R { get { return red;   } }
        public int G { get { return green; } }
        public int B { get { return blue;  } }
        
        public static Color FromArgb( int alpha, int red, int green, int blue )
        {
            Color result = new Color( );
            result.alpha = alpha;
            result.red   = red;
            result.green = green;
            result.blue  = blue;
            return result;
        }
    }
}

