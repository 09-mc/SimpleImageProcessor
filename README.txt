Created by: Cian Martyn
Student ID: G00398276

Table of content

1) Introduction
2) Program operation 
3) Notes
4) List of optional extras
5) References


1. Introduction

This program was created to serve as a picture editor. Essentially we are using 2D image arrays, looping over them
to create a filter effect using a convolution kernel. This program can be used either through an IDE or command line,
although it must be noted that use via an IDE is not recommended as not all features will work.


2. Program operation

2.1 Main Menu
On running the program, you will be brought to a mini menu giving you the option to enter the program or else quit and
shut down the terminal. 

2.2 Filter choice
On selecting Image Editor, you are brought to a menu option to use either a pre-loaded filter or to create your own
filter. 

2.2.1 Pre-loaded filter
The details of the pre-loaded filter are listed in the class "Kernels". There are 11 pre-loaded options which
you can chose from if you select this option (see below).

2.2.2 Create your own filter (Extra feature)
When creating your own filter, you will first be asked for the order of the kernel. This relates to the size of the kernel
e.g. if you chose 3 as your order, you would get a 3x3 kernel. You will then be asked to enter the kernel numbers
one individually starting with the number in position (0,0), hit enter to move on to the next. It is also important to 
note that the sum of the kernel elements should equal 0, although it is not a necessity. If the sum is less than 0, you
will notice the picture will darken. If the sum is greater than 0 then it will brighten.

2.3 Image source
Once you have selected the type of filter you wish to use, you will then be asked to decide the source of the image that
you wish to process. It is possible to either use a local picture or to input a URL for editing.

2.3.1 Local Picture
You need to specify the path to the local image for editing. For example, when editing an image called Iceland.png on my 
desktop, I would enter C:\Users\cianm\Desktop\Iceland.png. The program will tell you if the image path you have entered
is incorrect.

2.3.2 URL path (Extra Feature)
You need to specify the URL path to the image for editing. The program will tell you if the path is incorrect For example, 
I entered https://e0.365dm.com/21/08/1600x900/skysports-sadio-mane-liverpool_5485525.jpg?20210821141804 for testing 
purposes which worked perfectly.

2.4 The nitty gritty
Once the program has accepted the input image source, the hard work for you is done! Please allow 10-15 seconds sometimes
for the image to be processed although this perhaps will fluctuate depending on your processor.


3. Notes

1) Saved images go to the project folder>bin folder
2) Tested on other input file types than .png and it works fine
3) The naming convention for the output file is all one word. You can use underscore to link words together
4) Custom kernel has been tested up to a 5x5 matrix but allows for much more

4. Extras

Create your own filter (Section 2.2.2)
URL path for image (Section 2.3.2)
Image wrapping used to filter edge pixels

5. References

http://tech.abdulfatir.com/2014/05/kernel-image-processing.html
https://www.infoworld.com/article/2076764/image-processing-with-java-2d.html
https://rosettacode.org/wiki/Image_convolution#Java
http://learningprocessing.com/examples/chp15/example-15-13-Convolution
https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
https://stackoverflow.com/questions/601274/how-do-i-properly-load-a-bufferedimage-in-java