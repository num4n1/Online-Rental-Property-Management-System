package manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * controls the view and model for Manager
 */
public class ManagerController {
    ManagerView theView;
    Manager manager;

    /**
     * ctor
     * @param manager
     * @param theView
     */
    public ManagerController(Manager manager, ManagerView theView){
        this.theView= theView;
        this.manager = manager;
        theView.displayManagerView();


        /**
         * action listener
         * reacts to buttons pushed in the Manager View
         * to set report
         * change fees
         * change posting date
         */
        theView.addActionListener(e->{

            Object o = e.getSource();


            // see which button was pushed
            if(o == theView.getButton()){
                System.out.println("button1 pushed");
                manager.setReport( manager.generateRport() );
                theView.changeReportLabel(manager.getReport());

            }else if(o == theView.getButton2()){
                System.out.println("button2 pushed");

                theView.changeReportLabel("New Fees set");
                //functionality for changing the fees here

            }else if(o == theView.getButton3()){
                System.out.println("button3 pushed");
                theView.changeReportLabel("New Period set");
                // functionaity for setting a new period here

            }
            // set up the three buttons 

        });

    }
}
