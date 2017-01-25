package ftc.goal.counter;

/*
 * Created for FIRST Tech Challenge
 * To count balls scored in the Goals
 * During the 2016 - 2017 Game
 */

import static ftc.goal.counter.GoalCounterUI.logger;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.games.input.Component;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.DirectAndRawInputEnvironmentPlugin;

/**
 *
 * Joystick Test with JInput
 *@author afera
 * Alexander Fera
 * Fera Group
 * Novi, MI 48377
 *
 */
public class JoystickTest {
    static public boolean pressLstJSRedCenAbtn = false;
    static public boolean PressJSRedCenAbtn = false;
    static public boolean pressLstJSRedCenBbtn = false;
    static public boolean PressJSRedCenBbtn = false;
    static public boolean pressLstJSBlueCenAbtn = false;
    static public boolean PressJSBlueCenAbtn = false;
    static public boolean pressLstJSBlueCenBbtn = false;
    static public boolean PressJSBlueCenBbtn = false;
    static public boolean pressLstJSRedCorAbtn = false;
    static public boolean PressJSRedCorAbtn = false;
    static public boolean pressLstJSRedCorBbtn = false;
    static public boolean PressJSRedCorBbtn = false;
    static public boolean pressLstJSBlueCorAbtn = false;
    static public boolean PressJSBlueCorAbtn = false;
    static public boolean pressLstJSBlueCorBbtn = false;
    static public boolean PressJSBlueCorBbtn = false;
    static public boolean pressLstJSRedCenLT = false;
    static public boolean PressJSRedCenLT = false;
    static public boolean pressLstJSRedCenLB = false;
    static public boolean PressJSRedCenLB = false;
    static public boolean pressLstJSRedCenRT = false;
    static public boolean PressJSRedCenRT = false;
    static public boolean pressLstJSRedCenRB = false;
    static public boolean PressJSRedCenRB = false;
    static public boolean pressLstJSBlueCenLT = false;
    static public boolean PressJSBlueCenLT = false;
    static public boolean pressLstJSBlueCenLB = false;
    static public boolean PressJSBlueCenLB = false;
    static public boolean pressLstJSBlueCenRT = false;
    static public boolean PressJSBlueCenRT = false;
    static public boolean pressLstJSBlueCenRB = false;
    static public boolean PressJSBlueCenRB = false;
    static public boolean pressLstJSRedCorLT = false;
    static public boolean PressJSRedCorLT = false;
    static public boolean pressLstJSRedCorLB = false;
    static public boolean PressJSRedCorLB = false;
    static public boolean pressLstJSRedCorRT = false;
    static public boolean PressJSRedCorRT = false;
    static public boolean pressLstJSRedCorRB = false;
    static public boolean PressJSRedCorRB = false;
    static public boolean pressLstJSBlueCorLT = false;
    static public boolean PressJSBlueCorLT = false;
    static public boolean pressLstJSBlueCorLB = false;
    static public boolean PressJSBlueCorLB = false;
    static public boolean pressLstJSBlueCorRT = false;
    static public boolean PressJSBlueCorRT = false;
    static public boolean pressLstJSBlueCorRB = false;
    static public boolean PressJSBlueCorRB = false;
    static public boolean BlueCorIcon = false;
    static public boolean RedCorIcon = false;
    static public boolean BlueCenIcon = false;
    static public boolean RedCenIcon = false;
    static boolean alwaysTrue = true;
    
    static public ArrayList<Controller> foundControllers;
    static public ArrayList<Controller> searchControllers;

    public JoystickTest() {
        foundControllers = new ArrayList<>();
        searchControllers = new ArrayList<>();
        searchForControllers(false);
        
        // If at least one controller was found we start showing controller data on window.
        if(!foundControllers.isEmpty()){
            startShowingControllerData();
        }else{
            logger.info("No Controllers Found");
            SettingsUI.NoControllerName();
            SettingsUI.controllerLoopRun = false;
            startShowingControllerData();
        }
    }

    /**
     * Search (and save) for controllers of type Controller.Type.STICK,
     * Controller.Type.GAMEPAD, Controller.Type.WHEEL and Controller.Type.FINGERSTICK.
     * @param look
     */
    public static void searchForControllers(boolean look) {
        Controller[] controllers = null;
 
        DirectAndRawInputEnvironmentPlugin directEnv = new DirectAndRawInputEnvironmentPlugin();
        
        if (directEnv.isSupported()) {
            controllers = directEnv.getControllers();
        } else {
            logger.info("Direct Environment is not Supported, Controller Refresh will not work");
            controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        }
        
        for(int i = 0; i < controllers.length; i++){
            Controller controller = controllers[i];
            if (controller.getType() == Controller.Type.STICK || 
                controller.getType() == Controller.Type.GAMEPAD){
                // Add new controller to the list of all controllers.
                if(look){
                  searchControllers.add(controller);  
                  GoalCounterUI.logger.info("Search Controllers Found:" + controller.getName() + " - " + controller.hashCode());
                }else{
                  foundControllers.add(controller);
                  GoalCounterUI.logger.info("Found Controller: " + controller.getName() + " - " + controller.hashCode());
                }
                
                // Add new controller to the list on the window.
                SettingsUI.addControllerName(controller.getName() + " - " + controller.getPortNumber() + " - " + controller.hashCode());
            } 
        }
    }
    
    /**
     * Starts showing controller data on the window.
     */
    public static void startShowingControllerData(){
        while(alwaysTrue){
            GoalCounterUI.spinnersync(false);
            if(SettingsUI.controllerLoopRun){
                // Currently selected controller.
                int selectedControllerRedCen = SettingsUI.getSelectedControllerNameRedCen();
                if (selectedControllerRedCen == -1){
                        try {
                            Thread.sleep(250); // Pause the Joystick Checker while we update the Joysticks
                        } catch (InterruptedException ex) {
                            Logger.getLogger(JoystickTest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    selectedControllerRedCen = 0;
                }

                Controller controllerRedCen = foundControllers.get(selectedControllerRedCen);
                
                int selectedControllerBlueCen = SettingsUI.getSelectedControllerNameBlueCen();
                Controller controllerBlueCen = foundControllers.get(selectedControllerBlueCen);
                

               int selectedControllerRedCor = SettingsUI.getSelectedControllerNameRedCor();
               if (selectedControllerRedCor == -1){
                    selectedControllerRedCor = 0;
                }
                Controller controllerRedCor = foundControllers.get(selectedControllerRedCor);

                int selectedControllerBlueCor = SettingsUI.getSelectedControllerNameBlueCor();
                if (selectedControllerBlueCen == -1){
                    selectedControllerBlueCen = 0;
                }
                
                Controller controllerBlueCor = foundControllers.get(selectedControllerBlueCor);

            if (selectedControllerBlueCor == -1){
                    selectedControllerBlueCor = 0;
                }

                if( !controllerRedCen.poll() ){
                    //peach color
                    logger.severe("Cannot Poll Red Center Controller" + controllerRedCen.hashCode() + " - " + controllerRedCen.getName());
                    GoalCounterUI.RedCenJSStatus.setBackground(new java.awt.Color(238, 190, 171));
                }else if(!SettingsUI.RedCenBtn && !SettingsUI.RedCenLeft && !SettingsUI.RedCenRight){
                    GoalCounterUI.RedCenJSStatus.setBackground(new java.awt.Color(238, 190, 171));
                }else if(selectedControllerRedCen == selectedControllerRedCor && SettingsUI.RedCenBtn && SettingsUI.RedCorBtn){
                    //Orange
                    GoalCounterUI.RedCenJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else if(selectedControllerRedCen == selectedControllerRedCor && SettingsUI.RedCenLeft && SettingsUI.RedCorLeft){
                    //Orange
                    GoalCounterUI.RedCenJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else if(selectedControllerRedCen == selectedControllerRedCor && SettingsUI.RedCenRight && SettingsUI.RedCorRight){
                    //Orange
                    GoalCounterUI.RedCenJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else if(selectedControllerRedCen == selectedControllerBlueCen || selectedControllerRedCen == selectedControllerBlueCor){
                    //Orange
                    GoalCounterUI.RedCenJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else {
                    //green
                    GoalCounterUI.RedCenJSStatus.setBackground(new java.awt.Color(0, 166, 81));
                }

                if( !controllerRedCor.poll() ){
                    logger.severe("Cannot Poll Red Corner Controller" + controllerRedCor.hashCode() + " - " + controllerRedCor.getName());
                    GoalCounterUI.RedCorJSStatus.setBackground(new java.awt.Color(238, 190, 171));
                }else if(!SettingsUI.RedCorBtn && !SettingsUI.RedCorLeft && !SettingsUI.RedCorRight){
                    GoalCounterUI.RedCorJSStatus.setBackground(new java.awt.Color(238, 190, 171));
                }else if(selectedControllerRedCen == selectedControllerRedCor && SettingsUI.RedCenBtn && SettingsUI.RedCorBtn){
                    //Orange
                    GoalCounterUI.RedCorJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else if(selectedControllerRedCen == selectedControllerRedCor && SettingsUI.RedCenLeft && SettingsUI.RedCorLeft){
                    //Orange
                    GoalCounterUI.RedCorJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else if(selectedControllerRedCen == selectedControllerRedCor && SettingsUI.RedCenRight && SettingsUI.RedCorRight){
                        //Orange
                    GoalCounterUI.RedCorJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else if(selectedControllerRedCor == selectedControllerBlueCen || selectedControllerRedCor == selectedControllerBlueCor){
                    //Orange
                    GoalCounterUI.RedCorJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else {
                    //green
                    GoalCounterUI.RedCorJSStatus.setBackground(new java.awt.Color(0, 166, 81));
                }
                
                if( !controllerBlueCor.poll() ){
                    logger.severe("Cannot Poll Blue Corner Controller" + controllerBlueCor.hashCode() + " - " + controllerBlueCor.getName());
                    GoalCounterUI.BlueCorJSStatus.setBackground(new java.awt.Color(238, 190, 171));
                }else if(!SettingsUI.BlueCorBtn && !SettingsUI.BlueCorLeft && !SettingsUI.BlueCorRight){
                    GoalCounterUI.BlueCorJSStatus.setBackground(new java.awt.Color(238, 190, 171));
                }else if(selectedControllerBlueCen == selectedControllerBlueCor && SettingsUI.BlueCenBtn && SettingsUI.BlueCorBtn){
                    //Orange
                    GoalCounterUI.BlueCorJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else if(selectedControllerBlueCen == selectedControllerBlueCor && SettingsUI.BlueCenLeft && SettingsUI.BlueCorLeft){
                    //Orange
                    GoalCounterUI.BlueCorJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else if(selectedControllerBlueCen == selectedControllerBlueCor && SettingsUI.BlueCenRight && SettingsUI.BlueCorRight){
                    //Orange
                    GoalCounterUI.BlueCorJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else if(selectedControllerBlueCor == selectedControllerRedCen || selectedControllerBlueCor == selectedControllerRedCor){
                    //Orange
                    GoalCounterUI.BlueCorJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else {
                    //green
                    GoalCounterUI.BlueCorJSStatus.setBackground(new java.awt.Color(0, 166, 81));
                }
                
                if( !controllerBlueCen.poll() ){
                    logger.severe("Cannot Poll Blue Center Controller" + controllerBlueCen.hashCode() + " - " + controllerBlueCen.getName());
                    GoalCounterUI.BlueCenJSStatus.setBackground(new java.awt.Color(238, 190, 171));
                }else if(!SettingsUI.BlueCenBtn && !SettingsUI.BlueCenLeft && !SettingsUI.BlueCenRight){
                    GoalCounterUI.BlueCenJSStatus.setBackground(new java.awt.Color(238, 190, 171));
                }else if(selectedControllerBlueCen == selectedControllerBlueCor && SettingsUI.BlueCenBtn && SettingsUI.BlueCorBtn){
                    //Orange
                    GoalCounterUI.BlueCenJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else if(selectedControllerBlueCen == selectedControllerBlueCor && SettingsUI.BlueCenLeft && SettingsUI.BlueCorLeft){
                    //Orange
                    GoalCounterUI.BlueCenJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else if(selectedControllerBlueCen == selectedControllerBlueCor && SettingsUI.BlueCenRight && SettingsUI.BlueCorRight){
                        //Orange
                    GoalCounterUI.BlueCenJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else if(selectedControllerBlueCen == selectedControllerRedCen || selectedControllerBlueCen == selectedControllerRedCor){
                    //Orange
                    GoalCounterUI.BlueCenJSStatus.setBackground(new java.awt.Color(245, 126, 37));
                }else {
                    //green
                    GoalCounterUI.BlueCenJSStatus.setBackground(new java.awt.Color(0, 166, 81));
                }
                
                // Go trough all components of the controller.
                Component[] components = controllerRedCen.getComponents();
                for(int i=0; i < components.length; i++){
                    
                    Component component = components[i];
                    Identifier componentIdentifier = component.getIdentifier();

                    // Buttons
                    //if(component.getName().contains("Button")){ // If the language is not english, this won't work.
                    if(componentIdentifier.getName().matches("^[0]*$")){ // This is for Center Controller A Button
                        // Is button pressed?

                        if(component.getPollData() != 0.0f){
                            PressJSRedCenAbtn = true;    
                        }
                        else{
                            PressJSRedCenAbtn = false;
                        }


                        if(!PressJSRedCenAbtn){
                            pressLstJSRedCenAbtn = false;
                        }

                        GoalCounterUI.goal.IncrsRedCenA();



                    }

                    if(componentIdentifier.getName().matches("^[1]*$")){ // This is for Center Controller B Button
                        // Is button pressed?

                        if(component.getPollData() != 0.0f){
                            PressJSRedCenBbtn = true;    
                        }
                        else{
                            PressJSRedCenBbtn = false;
                        }

                        if(!PressJSRedCenBbtn){
                            pressLstJSRedCenBbtn = false;
                        }

                        GoalCounterUI.goal.DcrsRedCenB();

                    }

                    if(componentIdentifier.getName().matches("^[4]*$")){ // This is for Center Controller LB Button
                        // Is button pressed?

                        if(component.getPollData() != 0.0f){
                            PressJSRedCenLB = true;    
                        }
                        else{
                            PressJSRedCenLB = false;
                        }


                        if(!PressJSRedCenLB){
                            pressLstJSRedCenLB = false;
                        }

                        GoalCounterUI.goal.IncrsRedCenLB();

                    }

                    if(componentIdentifier.getName().matches("^[5]*$")){ // This is for Center Controller RB Button
                        // Is button pressed?

                        if(component.getPollData() != 0.0f){
                            PressJSRedCenRB = true;    
                        }
                        else{
                            PressJSRedCenRB = false;
                        }


                        if(!PressJSRedCenRB){
                            pressLstJSRedCenRB = false;
                        }

                        GoalCounterUI.goal.IncrsRedCenRB();

                    }

                    if(componentIdentifier == Component.Identifier.Axis.Z){
                        if(component.getPollData() <= -0.75){
                            PressJSRedCenRT = true;    
                        }
                        else{
                            PressJSRedCenRT = false;
                        }

                        if(!PressJSRedCenRT){
                            pressLstJSRedCenRT = false;
                        }
                        GoalCounterUI.goal.DcrsRedCenRT();
                        }

                    if(componentIdentifier == Component.Identifier.Axis.Z){
                        if(component.getPollData() <= 0.75){
                            PressJSRedCenLT = true;    
                        }
                        else{
                            PressJSRedCenLT = false;
                        }

                        if(!PressJSRedCenLT){
                            pressLstJSRedCenLT = false;
                        }
                        GoalCounterUI.goal.DcrsRedCenLT();
                        }
                }



                Component[] componentsbluecen = controllerBlueCen.getComponents();
                for(int i=0; i < componentsbluecen.length; i++)
                {
                    Component componentbluecen = componentsbluecen[i];
                    Identifier componentIdentifierbluecen = componentbluecen.getIdentifier();


                    // Buttons
                    //if(component.getName().contains("Button")){ // If the language is not english, this won't work.
                    if(componentIdentifierbluecen.getName().matches("^[0]*$")){ // This is for Center Controller A Button
                        // Is button pressed?

                        if(componentbluecen.getPollData() != 0.0f){
                            PressJSBlueCenAbtn = true;    
                        }else{
                            PressJSBlueCenAbtn = false;
                        }


                        if(!PressJSBlueCenAbtn){
                            pressLstJSBlueCenAbtn = false;
                        }

                        GoalCounterUI.goal.IncrsBlueCenA();

                    }

                    if(componentIdentifierbluecen.getName().matches("^[1]*$")){ // This is for Center Controller B Button
                        // Is button pressed?

                        if(componentbluecen.getPollData() != 0.0f){
                            PressJSBlueCenBbtn = true;    
                        }else{
                            PressJSBlueCenBbtn = false;
                        }

                        if(!PressJSBlueCenBbtn){
                            pressLstJSBlueCenBbtn = false;
                        }

                        GoalCounterUI.goal.DcrsBlueCenB();

                    }

                if(componentIdentifierbluecen.getName().matches("^[4]*$")){ // This is for Center Controller LB Button
                        // Is button pressed?

                        if(componentbluecen.getPollData() != 0.0f){
                            PressJSBlueCenLB = true;    
                        }else{
                            PressJSBlueCenLB = false;
                        }

                        if(!PressJSBlueCenLB){
                            pressLstJSBlueCenLB = false;
                        }

                        GoalCounterUI.goal.IncrsBlueCenLB();

                    }

                    if(componentIdentifierbluecen.getName().matches("^[5]*$")){ // This is for Center Controller RB Button
                        // Is button pressed?

                        if(componentbluecen.getPollData() != 0.0f){
                            PressJSBlueCenRB = true;    
                        }else{
                            PressJSBlueCenRB = false;
                        }

                        if(!PressJSBlueCenRB){
                            pressLstJSBlueCenRB = false;
                        }

                        GoalCounterUI.goal.IncrsBlueCenRB();

                    }

                    if(componentIdentifierbluecen == Component.Identifier.Axis.Z){
                        if(componentbluecen.getPollData() <= -0.75){
                            PressJSBlueCenRT = true;    
                        }else{
                            PressJSBlueCenRT = false;
                        }

                        if(!PressJSBlueCenRT){
                            pressLstJSBlueCenRT = false;
                        }
                        GoalCounterUI.goal.DcrsBlueCenRT();
                        }

                    if(componentIdentifierbluecen == Component.Identifier.Axis.Z){
                        if(componentbluecen.getPollData() <= 0.75){
                            PressJSBlueCenLT = true;    
                        }else{
                            PressJSBlueCenLT = false;
                        }

                        if(!PressJSBlueCenLT){
                            pressLstJSBlueCenLT = false;
                        }
                        GoalCounterUI.goal.DcrsBlueCenLT();
                        }           
                }

                            // Go trough all components of the controller.
                Component[] componentsredcor = controllerRedCor.getComponents();
                for(int i=0; i < componentsredcor.length; i++)
                {
                    Component componentredcor = componentsredcor[i];
                    Identifier componentIdentifierredcor = componentredcor.getIdentifier();

                    // Buttons
                    //if(component.getName().contains("Button")){ // If the language is not english, this won't work.
                    if(componentIdentifierredcor.getName().matches("^[0]*$")){ // This is for Center Controller A Button
                        // Is button pressed?

                        if(componentredcor.getPollData() != 0.0f){
                            PressJSRedCorAbtn = true;    
                        }else{
                            PressJSRedCorAbtn = false;
                        }
                        
                        if(!PressJSRedCorAbtn){
                            pressLstJSRedCorAbtn = false;
                        }
                        
                        GoalCounterUI.goal.IncrsRedCorA();

                    }

                    if(componentIdentifierredcor.getName().matches("^[1]*$")){ // This is for Center Controller B Button
                        // Is button pressed?

                        if(componentredcor.getPollData() != 0.0f){
                            PressJSRedCorBbtn = true;    
                        }else{
                            PressJSRedCorBbtn = false;
                        }

                        if(!PressJSRedCorBbtn){
                            pressLstJSRedCorBbtn = false;
                        }

                        GoalCounterUI.goal.DcrsRedCorB();

                    }

                    if(componentIdentifierredcor.getName().matches("^[4]*$")){ // This is for Center Controller LB Button
                        // Is button pressed?

                        if(componentredcor.getPollData() != 0.0f){
                            PressJSRedCorLB = true;    
                        }else{
                            PressJSRedCorLB = false;
                        }


                        if(!PressJSRedCorLB){
                            pressLstJSRedCorLB = false;
                        }

                        GoalCounterUI.goal.IncrsRedCorLB();                    
                    }

                    if(componentIdentifierredcor.getName().matches("^[5]*$")){ // This is for Center Controller RB Button
                        // Is button pressed?

                        if(componentredcor.getPollData() != 0.0f){
                            PressJSRedCorRB = true;    
                        }else{
                            PressJSRedCorRB = false;
                        }

                        if(!PressJSRedCorRB){
                            pressLstJSRedCorRB = false;
                        }

                        GoalCounterUI.goal.IncrsRedCorRB();

                    }

                    if(componentIdentifierredcor == Component.Identifier.Axis.Z){
                        if(componentredcor.getPollData() <= -0.75){
                            PressJSRedCorRT = true;    
                        }else{
                            PressJSRedCorRT = false;
                        }

                        if(!PressJSRedCorRT){
                            pressLstJSRedCorRT = false;
                        }
                        GoalCounterUI.goal.DcrsRedCorRT();
                    }

                    if(componentIdentifierredcor == Component.Identifier.Axis.Z){
                        if(componentredcor.getPollData() <= 0.75){
                            PressJSRedCorLT = true;    
                        }else{
                            PressJSRedCorLT = false;
                        }

                        if(!PressJSRedCorLT){
                            pressLstJSRedCorLT = false;
                        }
                        GoalCounterUI.goal.DcrsRedCorLT();
                    }
                }

                Component[] componentsbluecor = controllerBlueCor.getComponents();
                for(int i=0; i < componentsbluecor.length; i++)
                {
                    Component componentbluecor = componentsbluecor[i];
                    Identifier componentIdentifierbluecen = componentbluecor.getIdentifier();

                    // Buttons
                    //if(component.getName().contains("Button")){ // If the language is not english, this won't work.
                    if(componentIdentifierbluecen.getName().matches("^[0]*$")){ // This is for Center Controller A Button
                        // Is button pressed?

                        if(componentbluecor.getPollData() != 0.0f){
                            PressJSBlueCorAbtn = true;    
                        }else{
                            PressJSBlueCorAbtn = false;
                        }

                        if(!PressJSBlueCorAbtn){
                            pressLstJSBlueCorAbtn = false;
                        }

                        GoalCounterUI.goal.IncrsBlueCorA();

                    }

                    if(componentIdentifierbluecen.getName().matches("^[1]*$")){ // This is for Center Controller B Button
                        // Is button pressed?

                        if(componentbluecor.getPollData() != 0.0f){
                            PressJSBlueCorBbtn = true;    
                        }else{
                            PressJSBlueCorBbtn = false;
                        }

                        if(!PressJSBlueCorBbtn){
                            pressLstJSBlueCorBbtn = false;
                        }

                        GoalCounterUI.goal.DcrsBlueCorB();

                    }

                    if(componentIdentifierbluecen.getName().matches("^[4]*$")){ // This is for Center Controller LB Button
                        // Is button pressed?

                        if(componentbluecor.getPollData() != 0.0f){
                            PressJSBlueCorLB = true;    
                        }else{
                            PressJSBlueCorLB = false;
                        }

                        if(!PressJSBlueCorLB){
                            pressLstJSBlueCorLB = false;
                        }

                        GoalCounterUI.goal.IncrsBlueCorLB();

                    }

                    if(componentIdentifierbluecen.getName().matches("^[5]*$")){ // This is for Center Controller RB Button
                        // Is button pressed?

                        if(componentbluecor.getPollData() != 0.0f){
                            PressJSBlueCorRB = true;    
                        }else{
                            PressJSBlueCorRB = false;
                        }

                        if(!PressJSBlueCorRB){
                            pressLstJSBlueCorRB = false;
                        }

                        GoalCounterUI.goal.IncrsBlueCorRB();

                    }

                    if(componentIdentifierbluecen == Component.Identifier.Axis.Z){
                        if(componentbluecor.getPollData() <= -0.75){
                            PressJSBlueCorRT = true;    
                        }else{
                            PressJSBlueCorRT = false;
                        }

                        if(!PressJSBlueCorRT){
                            pressLstJSBlueCorRT = false;
                        }
                        GoalCounterUI.goal.DcrsBlueCorRT();
                        }

                    if(componentIdentifierbluecen == Component.Identifier.Axis.Z){
                        if(componentbluecor.getPollData() <= 0.75){
                            PressJSBlueCorLT = true;    
                        }else{
                            PressJSBlueCorLT = false;
                        }

                        if(!PressJSBlueCorLT){
                            pressLstJSBlueCorLT = false;
                        }
                        GoalCounterUI.goal.DcrsBlueCorLT();
                    }   

                }

                // We have to give processor some rest.
                try {
                    Thread.sleep(25);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JoystickTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        logger.severe("Joystick Update loop crashed");
    }
    
}

