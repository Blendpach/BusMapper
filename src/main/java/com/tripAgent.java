package com;

public class tripAgent extends masmt3.agent.MaSMTAgent {

    public tripAgent() {
        super();
    }

    @Override
    public void active() {

        System.out.println("I am " + super.agent);

    }

    @Override
    public void live() {
        int tripid = 1;
        System.out.println("Agent is Waiting for Trip to Completed");
        for (int i = 10; i > 0; i--) {
            System.out.println("Not Yet Completed Trip Id " + tripid);
            wait(1500);
        }
        setLive(false);

        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
    public void end() {

        System.out.println("End.");

        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

}
