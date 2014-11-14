import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.net.ConnectException;

/**
 * Created by wlf on 11/7/14.
 */




public class Send {

    private final static String QUEUE_NAME = "Connection between W and G";

    public static void main(String[] args) throws Exception {



        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("ec2-54-67-6-99.us-west-1.compute.amazonaws.com");
        Connection connection;
        Channel channel;
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "I love gaolifeng!!!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

            channel.close();
            connection.close();
    }
}