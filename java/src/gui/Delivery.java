package gui;

import Glovo.Order;

public class Delivery extends Thread {
	
	private Order order;
	private Main main;
	
	public Delivery(Order order, Main main) {
		this.order = order;
		this.main = main;
	}

    public void run(){
       System.out.println("Started");
       try {
    	   Thread.sleep(5000 * (int) order.getDeliveryTime().minutes);
       } catch (InterruptedException e) {
    	   System.out.println("Error in delivery");
       }
       System.out.println("Ended");
       order.finishDelivery();
       main.triggerDelivery();
    }
  }
