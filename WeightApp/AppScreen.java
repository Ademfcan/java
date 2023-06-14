import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class AppScreen {
  private static Font font = new Font("sans", Font.BOLD, 20);
  private static Font Sfont = new Font("sans", Font.BOLD, 15);
  // private static JPanel signUpPanel;
  private static JFrame frame;
  private static JTabbedPane mainPane;
  private static JPanel mainLayout = new JPanel(new BorderLayout());
  private static boolean IsSignedIn = false;
  JPanel signInPanel;
  JPanel signUpPanel;
  JPanel mainScreen;

  JTextField UsernameInput;
  JTextField PasswordInput;

  JTextField CreatePasswordInput;
  JTextField CreateUsernameInput;
  JTextField accWeightInput;
  JTextField accNameInput;
  JSpinner accAgeInput;

  public static final String SIGNIN_CMD = "signin";
  public static final String SIGNUP_CMD = "signup";
  public static final String CORRECTPASSOWORD_CMD = "PASSWORDCORRECT";

  public void InitAppScreen() { 
    frame = new JFrame("WeightApp");
    mainPane = new JTabbedPane();
    mainPane.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {  
      @Override  
      protected int calculateTabAreaHeight(int tab_placement, int run_count, int max_tab_height) {  
          return -1;  // don't show the tab bar
      }  
  });  
    //adding the 3 panels to mainpane
    mainPane.add("HomeScreen", mainScreen);
    
    mainPane.add("SignIn", signInPanel);
    mainPane.add("SignUp", signUpPanel);
    //adding mainpane to layout
    mainLayout.add(mainPane);
    //frame.setBackground(Color.gray);
    frame.setIconImage(
        new ImageIcon("C:\\Users\\Adem\\Downloads\\vecteezy_dumbbell-icon-symbol-sign_630858").getImage());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1000, 1000);

    frame.add(mainLayout);
    frame.setVisible(true);

  }

  public void SwitchPanel(String cmd) {
    if (cmd.equals(SIGNIN_CMD)) {
      // signInPanel.setVisible(true);
      // signUpPanel.setVisible(false);
      // mainScreen.setVisible(false);
      mainPane.setSelectedIndex(1);

      // mainLayout.setComponentZOrder(signInPanel, 0);
      // mainLayout.setComponentZOrder(signUpPanel, 1);
      // mainLayout.setComponentZOrder(mainScreen, 2);

    } else if (cmd.equals(SIGNUP_CMD)) {
      // signInPanel.setVisible(false);
      // signUpPanel.setVisible(true);
      // mainScreen.setVisible(false);
      if(mainPane == null){
        System.out.println("balls");
      }
      else{
        mainPane.setSelectedIndex(2);
      }

      // mainLayout.setComponentZOrder(signInPanel, 1);
      // mainLayout.setComponentZOrder(signUpPanel, 0);
      // mainLayout.setComponentZOrder(mainScreen, 2);

    } else if (cmd.equals(CORRECTPASSOWORD_CMD)) {
      // signInPanel.setVisible(false);
      // signUpPanel.setVisible(false);
      // mainScreen.setVisible(true);
      mainPane.setSelectedIndex(0);

      // mainLayout.setComponentZOrder(signInPanel, 1);
      // mainLayout.setComponentZOrder(signUpPanel, 1);
      // mainLayout.setComponentZOrder(mainScreen, 0);

    }
  }

  public void checkSignIn() {
    String userNameString;
    String passWordString;
    userNameString = UsernameInput.getText();
    passWordString = PasswordInput.getText();
    if (Controls.CheckUser(userNameString, passWordString)) {
      System.out.println("Account Exists");
      SwitchPanel(CORRECTPASSOWORD_CMD);
    } else {
      System.out.println("No user");
    }
  }

  public void createAccount() {

    String WeightInput = accWeightInput.getText();
    String UsernameInput = CreateUsernameInput.getText();
    String PasswordInput = CreatePasswordInput.getText();
    String ActualNameofUser = accNameInput.getText();
    int Age = (int) accAgeInput.getValue();
    // System.out.println("bw: "+WeightInput +" Username: " + UsernameInput + "
    // Password: " + PasswordInput + " Name: " + ActualNameofUser + " Age: " + Age);
    Controls.GetUserValues(ActualNameofUser, Age, Integer.parseInt(WeightInput), UsernameInput, PasswordInput);
    Controls.addUsertoDB();
  }

  public void Show() {

    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        InitAppScreen();
      }
    });

  }

  public void CreateTopMenu() {
    JMenuBar menuBar = new JMenuBar();
    JMenu Set = new JMenu("Settings");
    JMenu Users = new JMenu("Users");
    UIManager.put("menuBar.font", font);
    menuBar.setFont(font);

    menuBar.add(Set);
    menuBar.add(Users);
    JMenuItem LD = new JMenuItem("Light or Dark Mode");
    JMenuItem FS = new JMenuItem("Font Size ");
    JMenuItem LA = new JMenuItem("Language ");

    Set.add(LD);
    Set.add(FS);
    Set.add(LA);

    JMenuItem ChangeUser = new JMenuItem("Switch User ");
    JMenuItem LogOut = new JMenuItem("Log out ");
    JMenuItem ChangeAvatar = new JMenuItem("Change Avatar ");
    JMenuItem ChangeUsername = new JMenuItem("Change Username ");

    Users.add(ChangeAvatar);
    Users.add(ChangeUsername);
    Users.add(ChangeUser);
    Users.add(LogOut);
    mainLayout.add(BorderLayout.NORTH, menuBar);

    // return menuBar;
  }

  // create sign in screen
  public void createSignIn() {
    /*
     * Title.setBorder(BorderFactory.createLineBorder(Color.BLACK));
     * SignIn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
     * Username.setBorder(BorderFactory.createLineBorder(Color.BLACK));
     * Password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
     * UsernameInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
     * PasswordInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
     */
    // creating title and caption
    signInPanel = new JPanel(new GridBagLayout());
    //signInPanel.setOpaque(true);
    //signInPanel.setBackground(Color.white);
    GridBagConstraints c = new GridBagConstraints();
    JLabel Title = new JLabel("          Weight Tracker          ");
    Title.setFont(font);
    c.gridx = 0;
    c.gridy = 0;
    c.gridheight = 1;
    c.gridwidth = 2;
    c.anchor = GridBagConstraints.CENTER;
    signInPanel.add(Title, c);

    JLabel SignIn = new JLabel("Sign In");
    SignIn.setFont(Sfont);
    c.gridx = 0;
    c.gridy = 1;
    c.gridheight = 1;
    c.gridwidth = 2;
    c.anchor = GridBagConstraints.CENTER;
    signInPanel.add(SignIn, c);
    // Username Input
    JLabel Username = new JLabel("Username");
    Username.setFont(Sfont);
    c.gridx = 0;
    c.gridy = 2;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    signInPanel.add(Username, c);

    UsernameInput = new JTextField(15);

    c.gridx = 1;
    c.gridy = 2;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    signInPanel.add(UsernameInput, c);

    // Password Input
    JLabel Password = new JLabel("Password");
    Password.setFont(Sfont);
    c.gridx = 0;
    c.gridy = 3;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    signInPanel.add(Password, c);

    PasswordInput = new JTextField(15);
    c.gridx = 1;
    c.gridy = 3;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    signInPanel.add(PasswordInput, c);
    // Button to check Username and password
    JButton check = new JButton("Sign In");
    check.setFont(Sfont);
    c.gridx = 0;
    c.gridy = 4;
    c.gridheight = 1;
    c.gridwidth = 2;
    c.anchor = GridBagConstraints.CENTER;
    check.setActionCommand("SignInAttempt");
    check.addActionListener(new ButtonOnClick());

    signInPanel.add(check, c);
    // button for the forgot password screen
    JButton forgotPass = new JButton("Forgot Password");
    forgotPass.setFont(Sfont);
    forgotPass.setForeground(Color.BLUE.darker());
    forgotPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    forgotPass.setOpaque(false);
    forgotPass.setContentAreaFilled(false);
    forgotPass.setBorderPainted(false);
    c.gridx = 1;
    c.gridy = 7;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    signInPanel.add(forgotPass, c);
    // button for going to the sign up screen
    JButton createUser = new JButton("Create User");
    createUser.setFont(Sfont);
    createUser.setForeground(Color.BLUE.darker());
    createUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    createUser.setOpaque(false);
    createUser.setContentAreaFilled(false);
    createUser.setBorderPainted(false);
    c.gridx = 0;
    c.gridy = 7;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    createUser.setActionCommand(SIGNUP_CMD);
    createUser.addActionListener(new ButtonOnClick());
    signInPanel.add(createUser, c);
    //signInPanel.setSize(frame.getBounds().x, frame.getBounds().y);
    

  }

  // creating sign up screen
  public void createSignUP() {
    /*
     * Title.setBorder(BorderFactory.createLineBorder(Color.BLACK));
     * SignIn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
     * Username.setBorder(BorderFactory.createLineBorder(Color.BLACK));
     * Password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
     * UsernameInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
     * PasswordInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
     */
    // creating title and caption + all the layout stuff
    signUpPanel = new JPanel(new GridBagLayout());
    //signUpPanel.setOpaque(true);
    //signUpPanel.setBackground(Color.white);

    GridBagConstraints c = new GridBagConstraints();
    //title for the app
    JLabel Title = new JLabel("          Weight Tracker          ");
    Title.setFont(font);
    // c.weightx = 0.5;
    // c.weighty = 0.5;
    c.gridx = 0;
    c.gridy = 0;
    c.gridheight = 1;
    c.gridwidth = 2;
    c.anchor = GridBagConstraints.CENTER;
    signUpPanel.add(Title, c);
    // title showing this is the sign in screen
    JLabel SignIn = new JLabel("Sign Up");
    SignIn.setFont(Sfont);
    c.gridx = 0;
    c.gridy = 1;
    // c.weightx = 0.5;
    // c.weighty = 0.5;
    c.gridheight = 1;
    c.gridwidth = 2;
    c.anchor = GridBagConstraints.CENTER;
    signUpPanel.add(SignIn, c);
    // getting persons name
    JLabel accName = new JLabel("Your Name");
    accName.setFont(Sfont);
    c.gridx = 0;
    c.gridy = 2;
    // c.weightx = 0.5;
    // c.weighty = 0.5;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    signUpPanel.add(accName, c);
    // input to see the persons name
    accNameInput = new JTextField(15);

    c.gridx = 1;
    c.gridy = 2;
    // c.weightx = 0.5;
    // c.weighty = 0.5;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    signUpPanel.add(accNameInput, c);

    // getting persons age using jspinner
    SpinnerModel ageSpinner = new SpinnerNumberModel(25, 0, 100, 1);
    accAgeInput = new JSpinner(ageSpinner);
    /*
     * att 1
     * int w = accAgeInput.getWidth();
     * int h = accAgeInput.getHeight();
     * Dimension d = new Dimension(w * 2, h);
     * accAgeInput.setPreferredSize(d);
     * accAgeInput.setMinimumSize(d);
     */

    double weightNum = 0;
    Component mySpinnerEditor = accAgeInput.getEditor();

    JFormattedTextField jftf = ((JSpinner.DefaultEditor) mySpinnerEditor).getTextField();

    jftf.setColumns(10);

    c.gridx = 1;
    c.gridy = 3;
    // c.weightx = weightNum;
    // c.weighty = weightNum;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    signUpPanel.add(accAgeInput, c);
    // titile showing that we want age
    JLabel accAge = new JLabel("Your Age");
    accAge.setFont(Sfont);
    c.gridx = 0;
    c.gridy = 3;
    // c.weightx = weightNum;
    // c.weighty = weightNum;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    signUpPanel.add(accAge, c);

    // getting persons bodyweight
    JLabel accWeight = new JLabel("Your BW");
    accAge.setFont(Sfont);
    c.gridx = 0;
    c.gridy = 4;
    // c.weightx =1;
    // c.weighty = 0.3;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    signUpPanel.add(accWeight, c);
    //input for that bodyweight
    accWeightInput = new JTextField(15);
    c.gridx = 1;
    c.gridy = 4;
    // c.weightx =1;
    // c.weighty = 0.7;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    signUpPanel.add(accWeightInput, c);

    // getting the persons wanted username
    JLabel Username = new JLabel("New Username");
    Username.setFont(Sfont);
    c.gridx = 0;
    c.gridy = 5;
    // c.weightx = 1;
    // c.weighty = 1;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    signUpPanel.add(Username, c);
    //input for that persons username
    CreateUsernameInput = new JTextField(15);
    c.gridx = 1;
    c.gridy = 5;
    // c.weightx = 1;
    // c.weighty = 1;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    signUpPanel.add(CreateUsernameInput, c);

    // getting the persons wanted password
    JLabel Password = new JLabel("New Password");
    Password.setFont(Sfont);
    c.gridx = 0;
    c.gridy = 6;
    // c.weightx = 1;
    // c.weighty = 1;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    signUpPanel.add(Password, c);
    // input for that password
    CreatePasswordInput = new JTextField(15);
    c.gridx = 1;
    c.gridy = 6;
    // c.weightx = 1;
    // c.weighty = 1;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    signUpPanel.add(CreatePasswordInput, c);

    // button to create account
    JButton createAcc = new JButton("Create Account");
    createAcc.setFont(Sfont);
    c.gridx = 0;
    c.gridy = 7;
    // c.weightx = weightNum;
    // c.weighty = weightNum;
    c.gridheight = 1;
    c.gridwidth = 2;
    c.anchor = GridBagConstraints.CENTER;
    signUpPanel.add(createAcc, c);
    createAcc.setActionCommand("SignUpAttempt");
    createAcc.addActionListener(new ButtonOnClick());

    // button to take you to sign in screen
    JButton alreadyHasAccount = new JButton("Sign in to existing account");
    alreadyHasAccount.setFont(Sfont);
    alreadyHasAccount.setForeground(Color.BLUE.darker());
    alreadyHasAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    alreadyHasAccount.setOpaque(false);
    alreadyHasAccount.setContentAreaFilled(false);
    alreadyHasAccount.setBorderPainted(false);
    c.gridx = 0;
    c.gridy = 8;
    // c.weightx = weightNum;
    // c.weighty = weightNum;
    c.gridheight = 1;
    c.gridwidth = 2;
    c.anchor = GridBagConstraints.CENTER;
    alreadyHasAccount.setActionCommand(SIGNIN_CMD);
    alreadyHasAccount.addActionListener(new ButtonOnClick());
    signUpPanel.add(alreadyHasAccount, c);
    //signUpPanel.setSize(frame.getBounds().x, frame.getBounds().y);
    

  }

  public void HomeScreen() {
    
    mainScreen = new JPanel(new GridBagLayout());

    // mainScreen.setSize(1000, 1000);
    GridBagConstraints c = new GridBagConstraints();
    JLabel title = new JLabel("Homescreen");
    title.setFont(Sfont);
    c.gridx = 0;
    c.gridy = 0;
    c.gridheight = 1;
    c.gridwidth = 2;
    c.weighty = .30;
    mainScreen.add(title, c);
    mainLayout.add(mainScreen);
    // make the panel that shows your goals
    createGoalsSubPanel();
    // make the panel that shows your user and stuff about it
    createUsersSubPanel();
    

    // make the panel that shows options such as log out or switch account
    createOptionsSubPanel();

    // make the panel that shows a calendar with your training
    createCalendarSubPanel();

  }

  private void createGoalsSubPanel(){
    GridBagConstraints c = new GridBagConstraints();
    JPanel goalsPanel = new JPanel(new GridBagLayout());
    //goalsPanel.setOpaque(true);
    //goalsPanel.setBackground(Color.white);
    int defaultGoal = 0;
    JLabel goals = new JLabel("Goals");
    c.gridx = 0;
    c.gridy = 0;
    c.gridheight = 1;
    c.gridwidth = 1;
    // c.weightx = .70;
    c.anchor = GridBagConstraints.CENTER;
    goalsPanel.add(goals, c);

    JButton editGoals = new JButton("⚙️");
    editGoals.setOpaque(false);
    editGoals.setContentAreaFilled(false);
    editGoals.setBorderPainted(false);
    editGoals.setFont(Sfont);

    c.gridx = 3;
    c.gridy = 0;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    goalsPanel.add(editGoals, c);
    // dhdhdhdhdhhd
    JLabel goal1 = new JLabel("Bench");
    c.gridx = 0;
    c.gridy = 2;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    goalsPanel.add(goal1, c);
    JLabel goal2 = new JLabel("Squat");
    c.gridx = 1;
    c.gridy = 2;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    goalsPanel.add(goal2, c);

    JLabel goal3 = new JLabel("Deadlift");
    c.gridx = 2;
    c.gridy = 2;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    goalsPanel.add(goal3, c);

    JTextField goal1result = new JTextField(10);
    c.gridx = 0;
    c.gridy = 3;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    goalsPanel.add(goal1result, c);

    JTextField goal2result = new JTextField(10);
    c.gridx = 1;
    c.gridy = 3;
    c.gridheight = 1;
    c.gridwidth = 1;

    goalsPanel.add(goal2result, c);
    c.anchor = GridBagConstraints.CENTER;
    JTextField goal3result = new JTextField(10);
    c.gridx = 2;
    c.gridy = 3;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.anchor = GridBagConstraints.CENTER;
    goalsPanel.add(goal3result, c);

    c.gridx = 1;
    c.gridy = 1;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.weighty = .35;
    //mainScreen.setSize(frame.getBounds().x, frame.getBounds().y);
    mainScreen.add(goalsPanel, c);
    

  }


  private  void createUsersSubPanel(){
    GridBagConstraints c = new GridBagConstraints();
    
    JPanel userPanel = new JPanel(new BorderLayout());
    JLabel userIcon = new JLabel("Image Here");
    userPanel.add(userIcon, BorderLayout.CENTER);
    JLabel NameAndLastName = new JLabel(Controls.GetName() + "(" + Controls.GetUsername()+")");
    userPanel.add(NameAndLastName, BorderLayout.SOUTH);

    JLabel age = new JLabel(new Integer(Controls.GetAge()).toString());
    userPanel.add(age, BorderLayout.PAGE_END);

    JLabel weight = new JLabel(new Integer(Controls.GetWeight()).toString());
    userPanel.add(weight, BorderLayout.PAGE_END);
    c.gridx =0;
    c.gridy = 1;
    c.gridheight =1;
    c.gridwidth = 1;
    mainScreen.add(userPanel, c);

  }
  
  private  void createOptionsSubPanel(){
    GridBagConstraints c = new GridBagConstraints();
    JPanel optionsPanel = new JPanel();
    optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));

    JButton SignOut = new JButton("Sign Out⇱");
    SignOut.setActionCommand(SIGNUP_CMD);
    SignOut.addActionListener(new ButtonOnClick());
    JButton SwitchUser = new JButton("Switch User");
    SignOut.setActionCommand(SIGNIN_CMD);
    SwitchUser.addActionListener(new ButtonOnClick());
    JButton AppOptions = new JButton("App Settings");

    optionsPanel.add(SignOut);
    optionsPanel.add(SwitchUser);
    optionsPanel.add(AppOptions);
    c.gridx = 0;
    c.gridy = 2;
    c.gridheight = 1;
    c.gridwidth = 1;
    mainScreen.add(optionsPanel, c);


  }

  private void createCalendarSubPanel(){
    JPanel trainingLogPanel = new JPanel(new BorderLayout());
  }
  
  
  // making the buttons do stuff
  private class ButtonOnClick implements ActionListener {
    public  void actionPerformed(ActionEvent e) {
      String command = e.getActionCommand();
      SwitchPanel(command);
      // String[] SignUp_In = e.getActionCommand().split(",");
      if (e.getActionCommand().equals("SignInAttempt")) {
        // System.out.println(e.getActionCommand());
        // System.out.println(SignUp_In[1] + SignUp_In[2]);
        checkSignIn();
      }

      if (e.getActionCommand().equals("SignUpAttempt")) {
        createAccount();
      }

    }
  }

}
