package renter;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import javax.swing.*;

// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.util.ArrayList; // import the ArrayList class

// import javax.swing.plaf.TextUI;




public class RenterController {
    RenterView theView; // way t
    Renter renter;
    ArrayList<String> ctr = new ArrayList<>();
    ArrayList<String> results = new ArrayList<>();


    /**
     * ctor
     * @param theView
     * @param renter
     */
    public RenterController(RenterView theView, Renter renter){
        
        this.theView = theView;
        this.renter = renter;
        ArrayList<String> ctr = new ArrayList<>();

      

        /**
         * the action lsitener fort the renter page for when buttons are pushed
         */
        theView.addActionListener(e->{
            // clear the ctr arry first and use the one in controler no the one in view
            // Object o = e.getSource();
         
            ctr.clear();
            results.clear();
            ctr.add(theView.getTypefield());
            ctr.add(theView.getBedfield());
            ctr.add(theView.getBathfield());
            ctr.add(theView.getFurnishedfield());
            ctr.add(theView.getQuadrantfield());

            results =  renter.performSearch(ctr);
            
            System.out.println("------" + results);

                // theView.setResultsLabel("a------------a\n----------------");
                String returnValue= "";

                for (String temp : results) {
                    // append all the property info to the 
                    
                    // use temp to get property info 
                    returnValue += renter.getPropertyinfo(temp); // and the returnValue for this 
                    // or put this in an array to send to the view so i can make a button of reach 
                    returnValue += "<br>=========================<br>";

                }

                // make the returnValue a bit nicer in getProperty info

                theView.changeResultsLabel("<html>"+returnValue+"<html>");
        
        });

    }


}//end class

