package com.jinyue.observer;

import org.junit.Test;

/**
 * 来源《java-design-patterns》一书。
 *
 * 用户订阅足球赛事的举例
 * Observer Pattern:
 * Sports Lobby is a fantastic sports site for sport lovers. They cover almost all kinds of sports and provide the latest news,
 * information, matches scheduled dates, information about a particular player or a team. Now, they are planning to provide live
 * commentary or scores of matches as an SMS service, but only for their premium users. Their aim is to SMS the live score, match
 * situation, and important events after short intervals. As a user, you need to subscribe to the package and when there is a live
 * match you will get an SMS to the live commentary. The site also provides an option to unsubscribe from the package whenever
 * you want to.
 * As a developer, the Sport Lobby asked you to provide this new feature for them. The reporters of the Sport Lobby will sit in
 * the commentary box in the match, and they will update live commentary to a commentary object. As a developer your job is to
 * provide the commentary to the registered users by fetching it from the commentary object when it’s available. When there is an
 * update, the system should update the subscribed users by sending them the SMS.
 * This situation clearly shows one-to-many mapping between the match and the users, as there could be many users to subscribe to
 * a single match. The Observer Design Pattern is best suited to this situation, let’s see about this pattern and then create the feature
 * for Sport Lobby.
 */
public class ObserverTest {

    @Test
    public void testObserverPattern(){
        Subject subject = new CommentaryObject("Soccer Match [2014AUG24]");
        Observer observer = new SMSUser(subject, "Adam Warner [New York]");
        observer.subscribe();
        System.out.println();
        Observer observer2 = new SMSUser(subject, "Tim Ronney [London]");
        observer2.subscribe();
        Commentary cObject = ((Commentary)subject);
        cObject.setCommentary("Welcome to live Soccer match");
        cObject.setCommentary("Current score 0-0");
        System.out.println();
        observer2.unSubcribe();
        System.out.println();
        cObject.setCommentary("It’s a goal!!");
        cObject.setCommentary("Current score 1-0");
        System.out.println();
        Observer observer3 = new SMSUser(subject, "Marrie [Paris]");
        observer3.subscribe();
        System.out.println();
        cObject.setCommentary("It’s another goal!!");
        cObject.setCommentary("Half-time score 2-0");
    }
}
