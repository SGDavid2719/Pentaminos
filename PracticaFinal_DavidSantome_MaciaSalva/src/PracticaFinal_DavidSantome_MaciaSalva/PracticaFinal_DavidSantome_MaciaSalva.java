package PracticaFinal_DavidSantome_MaciaSalva;

import java.awt.Color;
import java.util.*;
import java.util.logging.*;

/**
 * @author David Santomé Galván
 * @author Macià Salvà Salvà
 */
public class PracticaFinal_DavidSantome_MaciaSalva extends javax.swing.JFrame {

    Board board;
    Figure figure;

    private final Figure[] FigureList = {
        new Figure_F(), new Figure_I(), new Figure_L(),
        new Figure_N(), new Figure_P(), new Figure_T(),
        new Figure_U(), new Figure_V(), new Figure_W(),
        new Figure_X(), new Figure_Y(), new Figure_Z()
    };

    private ArrayList<Integer> lastFigureUsed = new ArrayList<>();

    private ArrayList<Color> solutions = new ArrayList<>();

    private int numberOfSolutions;
    private int iterations;
    private int remainingFigure = 12;
    private int bestSolution;
    private int solutionShow;

    private int speed;

    private int blockCheckCt;
    private final int[] blockCheck = new int[60];

    /**
     * Creates new form PracticaFinal_DavidSantome_MaciaSalva
     *
     * Initializes initComponents. Creates the JPanels. Initializes
     * blockedSquares and usedFigureList arrayLists. Sets speed to Very Fast.
     *
     * @param evt evt obtained by parameters
     *
     * @return nothing
     */
    public PracticaFinal_DavidSantome_MaciaSalva() {
        initComponents();
        CreateJpanels();

        speed = 100;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuBar = new javax.swing.JMenuBar();
        BoardSizeMenu = new javax.swing.JMenu();
        Size1 = new javax.swing.JMenuItem();
        Size2 = new javax.swing.JMenuItem();
        Size3 = new javax.swing.JMenuItem();
        Size4 = new javax.swing.JMenuItem();
        BlockSolveMenu = new javax.swing.JMenu();
        BlockItem = new javax.swing.JMenuItem();
        SolveItem = new javax.swing.JMenuItem();
        ClearItem = new javax.swing.JMenuItem();
        VelocityItem = new javax.swing.JMenu();
        VelocityItem1 = new javax.swing.JMenuItem();
        VelocityItem2 = new javax.swing.JMenuItem();
        VelocityItem3 = new javax.swing.JMenuItem();
        VelocityItem4 = new javax.swing.JMenuItem();
        VelocityItem5 = new javax.swing.JMenuItem();
        ShowSolutionsMenu = new javax.swing.JMenu();
        SolutionItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pentominos Solver");
        getContentPane().setLayout(new java.awt.GridLayout(1, 1));

        BoardSizeMenu.setText("Board Size");

        Size1.setText("6x10");
        Size1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Size1ActionPerformed(evt);
            }
        });
        BoardSizeMenu.add(Size1);

        Size2.setText("5x12");
        Size2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Size2ActionPerformed(evt);
            }
        });
        BoardSizeMenu.add(Size2);

        Size3.setText("4x15");
        Size3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Size3ActionPerformed(evt);
            }
        });
        BoardSizeMenu.add(Size3);

        Size4.setText("3x20");
        Size4.setToolTipText("");
        Size4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Size4ActionPerformed(evt);
            }
        });
        BoardSizeMenu.add(Size4);

        MenuBar.add(BoardSizeMenu);

        BlockSolveMenu.setText("Block/Solve");

        BlockItem.setText("Block");
        BlockItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlockItemActionPerformed(evt);
            }
        });
        BlockSolveMenu.add(BlockItem);

        SolveItem.setText("Solve");
        SolveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolveItemActionPerformed(evt);
            }
        });
        BlockSolveMenu.add(SolveItem);

        ClearItem.setText("Clear");
        ClearItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearItemActionPerformed(evt);
            }
        });
        BlockSolveMenu.add(ClearItem);

        MenuBar.add(BlockSolveMenu);

        VelocityItem.setText("Velocity");

        VelocityItem1.setText("Slow");
        VelocityItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VelocityItem1ActionPerformed(evt);
            }
        });
        VelocityItem.add(VelocityItem1);

        VelocityItem2.setText("Medium");
        VelocityItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VelocityItem2ActionPerformed(evt);
            }
        });
        VelocityItem.add(VelocityItem2);

        VelocityItem3.setText("Fast");
        VelocityItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VelocityItem3ActionPerformed(evt);
            }
        });
        VelocityItem.add(VelocityItem3);

        VelocityItem4.setText("Very Fast");
        VelocityItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VelocityItem4ActionPerformed(evt);
            }
        });
        VelocityItem.add(VelocityItem4);

        VelocityItem5.setText("Just Solutions");
        VelocityItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VelocityItem5ActionPerformed(evt);
            }
        });
        VelocityItem.add(VelocityItem5);

        MenuBar.add(VelocityItem);

        ShowSolutionsMenu.setText("Show Best Solutions");

        SolutionItem.setText("Next Solution");
        SolutionItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolutionItemActionPerformed(evt);
            }
        });
        ShowSolutionsMenu.add(SolutionItem);

        MenuBar.add(ShowSolutionsMenu);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Sets how many rows and columns. 6x10.
     *
     * @param evt evt obtained by parameters
     *
     * @return nothing
     */
    private void Size1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Size1ActionPerformed
        changeLayout(6, 10);
    }//GEN-LAST:event_Size1ActionPerformed

    /**
     * Sets how many rows and columns. 5x12.
     *
     * @param evt evt obtained by parameters
     *
     * @return nothing
     */
    private void Size2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Size2ActionPerformed
        changeLayout(5, 12);
    }//GEN-LAST:event_Size2ActionPerformed

    /**
     * Sets how many rows and columns of the board. 4x15.
     *
     * @param evt evt obtained by parameters
     *
     * @return nothing
     */
    private void Size3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Size3ActionPerformed
        changeLayout(4, 15);
    }//GEN-LAST:event_Size3ActionPerformed

    /**
     * Sets how many rows and columns of the board. 3x20.
     *
     * @param evt evt obtained by parameters
     *
     * @return nothing
     */
    private void Size4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Size4ActionPerformed
        changeLayout(3, 20);
    }//GEN-LAST:event_Size4ActionPerformed

    /**
     * Gets if u blocked or not.
     *
     * @param evt evt obtained by parameters
     *
     * @return nothing
     */
    private void BlockItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlockItemActionPerformed
        System.out.println("iBlocked? " + board.getIBlocked());
    }//GEN-LAST:event_BlockItemActionPerformed

    /**
     * Sets solving true. Clears solution ArrayList to save new ones. Creates a
     * new thread to appreaciate the steps. When it ends shows the number of
     * solutions.
     *
     * Solver solves board without blocked squares and Solver2 with blocked
     * squares.
     *
     * @param evt evt obtained by parameters
     *
     * @return nothing
     */
    private void SolveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolveItemActionPerformed
        solutionShow = 0;
        board.setSolving(true);
        solutions.clear();
        if (board.getIBlocked()) {
            System.out.println("Solving with Solver2");
            new Thread(() -> {
                bestSolution = 0;
                numberOfSolutions = 0;
                iterations = 0;
                long start = System.currentTimeMillis() / 1000;
                //Starts solving the puzzle
                solver2(0, 0);
                long finish = System.currentTimeMillis() / 1000;
                System.out.println("Time: " + (finish - start));
                System.out.println("Solutions: " + numberOfSolutions);
                System.out.println("Iterations: " + iterations);
            }).start();
        } else {
            System.out.println("Solving with Solver");
            new Thread(() -> {
                numberOfSolutions = 0;
                iterations = 0;
                long start = System.currentTimeMillis() / 1000;
                //Starts solving the puzzle
                solver(0, 0);
                long finish = System.currentTimeMillis() / 1000;
                System.out.println("Time: " + (finish - start));
                System.out.println("Solutions: " + numberOfSolutions);
                System.out.println("Iterations: " + iterations);
            }).start();
        }
    }//GEN-LAST:event_SolveItemActionPerformed

    /**
     * Sets aborted true when you want to stop solving. Clears the board.
     * Removes all blocked squares.
     *
     * @param evt evt obtained by parameters
     *
     * @return nothing
     */
    private void ClearItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearItemActionPerformed
        board.setSolving(false);
        board.clearBoard();
        board.setAllUnblocked();
    }//GEN-LAST:event_ClearItemActionPerformed

    /**
     * Sets solving velocity. Slow.
     *
     * @param evt evt obtained by parameters
     *
     * @return nothing
     */
    private void VelocityItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VelocityItem1ActionPerformed
        speed = 600;
    }//GEN-LAST:event_VelocityItem1ActionPerformed

    /**
     * Sets solving velocity. Medium.
     *
     * @param evt evt obtained by parameters
     *
     * @return nothing
     */
    private void VelocityItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VelocityItem2ActionPerformed
        speed = 300;
    }//GEN-LAST:event_VelocityItem2ActionPerformed

    /**
     * Sets solving velocity. Fast.
     *
     * @param evt evt obtained by parameters
     *
     * @return nothing
     */
    private void VelocityItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VelocityItem3ActionPerformed
        speed = 100;
    }//GEN-LAST:event_VelocityItem3ActionPerformed

    /**
     * Sets solving velocity. Very fast.
     *
     * @param evt evt obtained by parameters
     *
     * @return nothing
     */
    private void VelocityItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VelocityItem4ActionPerformed
        speed = 20;
    }//GEN-LAST:event_VelocityItem4ActionPerformed

    /**
     * Sets solving velocity. Just solutions.
     *
     * @param evt evt obtained by parameters
     *
     * @return nothing
     */
    private void VelocityItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VelocityItem5ActionPerformed
        speed = 0;
    }//GEN-LAST:event_VelocityItem5ActionPerformed

    /**
     * Shows all best solutions found.
     *
     * @param evt evt obtained by parameters
     *
     * @return nothing
     */
    private void SolutionItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolutionItemActionPerformed
        // if solutions saved
        if (!solutions.isEmpty()) {
            System.out.println("Solution number: " + solutionShow);
            boardRepaintSolutions();
            if (solutionShow < numberOfSolutions - 1) {
                solutionShow++;
            } else {
                solutionShow = 0;
            }
        } else {
            System.out.println("0 solutions saved");
        }

    }//GEN-LAST:event_SolutionItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PracticaFinal_DavidSantome_MaciaSalva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PracticaFinal_DavidSantome_MaciaSalva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PracticaFinal_DavidSantome_MaciaSalva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PracticaFinal_DavidSantome_MaciaSalva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PracticaFinal_DavidSantome_MaciaSalva().setVisible(true);
            }
        });
    }

    /**
     * Creates 60 JPanels and sets a Layout of 6x10.
     *
     * @return nothing
     */
    private void CreateJpanels() {
        board = new Board();
        changeLayout(6, 10);
    }

    /**
     * Changes the layout of the board. Sets solving false. Clears the board.
     * Sets all squares unblocked.
     *
     * @param rows rows obtained by parameters
     *
     * @param columns columns obtained by parameters
     *
     * @return nothing
     */
    private void changeLayout(int rows, int columns) {
        board.newLayout(rows, columns);
        setSize(board.getWidth(), board.getHeight());
        add(board);
        setLocationRelativeTo(null);
        board.setSolving(false);
        board.clearBoard();
        board.setAllUnblocked();
    }

    /**
     * Is a recursive method that solves the puzzle. It uses backtraking. Solves
     * without blocked squares.
     *
     * @param posx x position
     *
     * @param posy y position
     *
     * @return nothing
     */
    private void solver(int posx, int posy) {
        // checks if is solving
        if (board.isSolving()) {
            // no remaining figures means solution found
            if (remainingFigure == 0) {
                if (newSolution()) {
                    // saves this new solution
                    saveSolution();
                    // increments number of solutions
                    numberOfSolutions++;
                    if (speed == 0) {
                        try {
                            Thread.sleep(10);
                            boardRepaint();
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PracticaFinal_DavidSantome_MaciaSalva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } else {
                // tries every cell of the grid (limited to the positions where
                // the piece is not outside the boundaries of the frame)
                // y
                for (int k = posy; k < board.getRows(); k++) {
                    // x
                    for (int l = posx; l < board.getColumns(); l++) {
                        // checks empty blocks left
                        if (!getAnySquareEmpty(k, l)) {
                            // loops over remaining figures
                            for (int numFigure = 0; numFigure < FigureList.length; numFigure++) {
                                // creates a new figure 
                                createFigure(numFigure);
                                // checks if this figure is used
                                if (!figure.getUsed()) {
                                    // considers all possible rotations of this figure
                                    for (int j = 0; j < figure.getRotations(); j++) {
                                        // if the cell is empty and the figure doesn't overlap with other figures
                                        if (putFigure(j, k, l)) {
                                            // adds the figure to the grid
                                            paintFigure(j, k, l, numFigure);
                                            // visual delay to paint the board while solving
                                            if (speed > 0) {
                                                try {
                                                    Thread.sleep(speed);
                                                    boardRepaint();
                                                } catch (InterruptedException ex) {
                                                    Logger.getLogger(PracticaFinal_DavidSantome_MaciaSalva.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                            remainingFigure--;
                                            iterations++;

                                            // if the figure doesn't leave any unfillable cell
                                            if (!obviousBlockExists()) {
                                                // recursively calls this function
                                                solver(posx, posy);
                                            }

                                            // after having tried, remove this figure and goes on
                                            removeFigure(j, k, l);
                                            if (speed > 0) {
                                                try {
                                                    Thread.sleep(speed);
                                                    boardRepaint();
                                                } catch (InterruptedException ex) {
                                                    Logger.getLogger(PracticaFinal_DavidSantome_MaciaSalva.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                            remainingFigure++;
                                            iterations++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Is a recursive method that solves the puzzle. It uses backtraking. Solves
     * with blocked squares.
     *
     * @param posx x position
     *
     * @param posy y position
     *
     * @return nothing
     */
    private void solver2(int posx, int posy) {
        // checks if is solving
        if (board.isSolving()) {
            // remaining figures but best solution found
            if (countBlockedSquares() > bestSolution) {
                // new best solution
                bestSolution = countBlockedSquares();
                // clears other solutions
                solutions.clear();
                // save new best solution
                saveSolution();
                // number of solutions 1
                numberOfSolutions = 1;
                if (speed == 0) {
                    try {
                        Thread.sleep(10);
                        boardRepaint();
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PracticaFinal_DavidSantome_MaciaSalva.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (countBlockedSquares() == bestSolution) {
                if (newSolution()) {
                    // saves this new solution
                    saveSolution();
                    // increments number of solutions
                    numberOfSolutions++;
                    if (speed == 0) {
                        try {
                            Thread.sleep(10);
                            boardRepaint();
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PracticaFinal_DavidSantome_MaciaSalva.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            // tries every cell of the grid (limited to the positions where
            // the piece is not outside the boundaries of the frame)
            // x
            for (int k = posx; k < board.getRows(); k++) {
                // y
                for (int l = posy; l < board.getColumns(); l++) {
                    // checks empty blocks left
                    if (!getAnySquareEmpty(k, l)) {
                        // loops over remaining figures
                        for (int numFigure = 0; numFigure < FigureList.length; numFigure++) {
                            // creates a new figure 
                            createFigure(numFigure);
                            // checks if this figure is used
                            if (!figure.getUsed()) {
                                // considers all possible rotations of this figure
                                for (int j = 0; j < figure.getRotations(); j++) {
                                    // if the cell is empty and the figure doesn't overlap with other figures
                                    if (putFigure(j, k, l)) {
                                        // adds the figure to the grid
                                        paintFigure(j, k, l, numFigure);
                                        // visual delay to paint the board while solving
                                        if (speed > 0) {
                                            try {
                                                Thread.sleep(speed);
                                                boardRepaint();
                                            } catch (InterruptedException ex) {
                                                Logger.getLogger(PracticaFinal_DavidSantome_MaciaSalva.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                        iterations++;

                                        // recursively calls this function
                                        solver2(posx, posy);

                                        // after having tried, remove this figure and goes on
                                        removeFigure(j, k, l);
                                        if (speed > 0) {
                                            try {
                                                Thread.sleep(speed);
                                                boardRepaint();
                                            } catch (InterruptedException ex) {
                                                Logger.getLogger(PracticaFinal_DavidSantome_MaciaSalva.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                        iterations++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Tries to place a figure checking blocked squares and board size.
     *
     * @param actualRotation actualRotation obtained by parameters
     *
     * @param x x obtained by parameters
     *
     * @param y y obtained by parameters
     *
     * @return true if it fits
     */
    private boolean putFigure(int actualRotation, int x, int y) {
        int position, m, l;
        int columns = board.getColumns();
        int rows = board.getRows();

        for (int i = 0; i < 10; i = i + 2) {
            m = figure.getSquares(actualRotation, i) + x;
            l = figure.getSquares(actualRotation, i + 1) + y;
            position = m * columns + l;
            if (position >= 60) {
                return false;
            } else if (board.getBlockedSquares(position)) {
                return false;
            } else if (l > columns - 1 || m > rows - 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Paints the figure.
     *
     * @param actualRotation actualRotation obtained by parameters
     *
     * @param x x obtained by parameters
     *
     * @param y y obtained by parameters
     *
     * @param pieceNumber pieceNumber obtained by parameters
     *
     * @return nothing
     */
    private void paintFigure(int actualRotation, int x, int y, int pieceNumber) {
        int position;
        for (int i = 0; i < 10; i = i + 2) {
            position = calculatePosition(actualRotation, i, x, y);
            board.setBoard(figure.getColor(), position);
            board.setBlockedSquares(position, true);
        }
        figure.setUsed(true);
        lastFigureUsed.add(pieceNumber);
    }

    /**
     * Removes the figure and blocked Squares by the figure.
     *
     * @param actualRotation actualRotation obtained by parameters
     *
     * @param x x obtained by parameters
     *
     * @param y y obtained by parameters
     *
     * @return nothing
     */
    private void removeFigure(int actualRotation, int x, int y) {
        int position;
        int pieceNumber = lastFigureUsed.get(lastFigureUsed.size() - 1);
        createFigure(pieceNumber);
        for (int i = 0; i < 10; i = i + 2) {
            position = calculatePosition(actualRotation, i, x, y);
            board.setBoard(Color.white, position);
            board.setBlockedSquares(position, false);
        }
        figure.setUsed(false);
        lastFigureUsed.remove(lastFigureUsed.size() - 1);
    }

    /**
     * Calculates the position of every square.
     *
     * @param actualRotation actualRotation obtained by parameters
     *
     * @param i i obtained by parameters
     *
     * @param x x obtained by parameters
     *
     * @param y y obtained by parameters
     *
     * @return position
     */
    private int calculatePosition(int actualRotation, int i, int x, int y) {
        int position, m, l;
        m = figure.getSquares(actualRotation, i) + x;
        l = figure.getSquares(actualRotation, i + 1) + y;
        position = m * board.getColumns() + l;
        return position;
    }

    /**
     * Creates a new figure by number in an array of figures.
     *
     * @param pieceNumber pieceNumber obtained by parameters
     *
     * @return nothing
     */
    private void createFigure(int pieceNumber) {
        figure = FigureList[pieceNumber];
    }

    /**
     * From the next square empty of the board it checks if a square never can
     * be filled because there is not enough space.
     *
     * @return true if never can be filled
     */
    private boolean obviousBlockExists() {
        blockCheckCt++;
        int forcedEmptyCt = 0;
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getColumns(); c++) {
                int blockSize = countEmptyBlock(r, c);
                if (blockSize % 5 == 0) {
                    continue;
                }
                forcedEmptyCt += blockSize % 5;
                if (forcedEmptyCt < 5) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Finds the size of one empty region on the board, recursive routine called
     * by obviousBlockExists.
     *
     * @return true if never can be filled
     */
    private int countEmptyBlock(int r, int c) {
        int index = r * board.getColumns() + c;
        if (blockCheck[index] == blockCheckCt || board.getBlockedSquares(index) == true) {
            return 0;
        }
        int c1 = c, c2 = c;
        while (c1 > 0 && board.getBlockedSquares((r * board.getColumns()) + (c1 - 1)) == false) {
            c1--;
        }
        while (c2 < board.getColumns() - 1 && board.getBlockedSquares((r * board.getColumns()) + (c2 + 1)) == false) {
            c2++;
        }
        for (int i = c1; i <= c2; i++) {
            blockCheck[r * board.getColumns() + i] = blockCheckCt;
        }
        int ct = c2 - c1 + 1;
        if (r > 1) {
            for (int i = c1; i <= c2; i++) {
                ct += countEmptyBlock(r - 1, i);
            }
        }
        if (r < board.getRows() - 1) {
            for (int i = c1; i <= c2; i++) {
                ct += countEmptyBlock(r + 1, i);
            }
        }
        return ct;
    }

    /**
     * Finds if a square is empty before last figure paint.
     *
     * @return true if there is an empty block
     */
    private boolean getAnySquareEmpty(int k, int l) {
        int position = k * board.getColumns() + l;

        for (int j = 0; j < position; j++) {
            if (board.getBlockedSquares(j) == false) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks how many notBlocked squares are.
     *
     * @return count
     */
    private int countBlockedSquares() {
        int count = 0;
        for (int i = 0; i < board.getBoardTotalSquares(); i++) {
            if (board.getBlockedSquares(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Paints the hole board.
     *
     * @return nothing
     */
    private void boardRepaint() {
        Color[] help = board.getBoard();
        for (int i = 0; i < 60; i++) {
            board.getComponent(i).setBackground(help[i]);
        }
    }

    /**
     * Paints found solutions from the ArrayList.
     *
     * @return nothing
     */
    private void boardRepaintSolutions() {
        for (int i = 0; i < board.getBoardTotalSquares(); i++) {
            board.getComponent(i).setBackground(solutions.get(i + 60 * solutionShow));
        }
    }

    /**
     * Saves the solution board in an ArrayList.
     *
     * @return nothing
     */
    private void saveSolution() {
        for (int i = 0; i < board.getBoardTotalSquares(); i++) {
            solutions.add(board.getBoardCell(i));
        }
    }

    /**
     * Returns if a solutions is new or not.
     *
     * @return new Solution
     */
    private boolean newSolution() {
        for (int i = 0; i < numberOfSolutions; i++) {
            int j = 0;
            while (board.getBoardCell(j) == solutions.get(j + 60 * i)) {
                if (j == board.getBoardTotalSquares() - 1) {
                    return false;
                } else {
                    j++;
                }
            }
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BlockItem;
    private javax.swing.JMenu BlockSolveMenu;
    private javax.swing.JMenu BoardSizeMenu;
    private javax.swing.JMenuItem ClearItem;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu ShowSolutionsMenu;
    private javax.swing.JMenuItem Size1;
    private javax.swing.JMenuItem Size2;
    private javax.swing.JMenuItem Size3;
    private javax.swing.JMenuItem Size4;
    private javax.swing.JMenuItem SolutionItem;
    private javax.swing.JMenuItem SolveItem;
    private javax.swing.JMenu VelocityItem;
    private javax.swing.JMenuItem VelocityItem1;
    private javax.swing.JMenuItem VelocityItem2;
    private javax.swing.JMenuItem VelocityItem3;
    private javax.swing.JMenuItem VelocityItem4;
    private javax.swing.JMenuItem VelocityItem5;
    // End of variables declaration//GEN-END:variables

}
