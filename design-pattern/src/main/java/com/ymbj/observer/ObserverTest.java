package com.ymbj.observer;

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
        // 新建一个足球比赛的主题
        Subject subject = new CommentaryObject("Soccer Match [2014AUG24]");

        // 新建一个名为“Adam Warner”的观察者
        Observer observer = new SMSUser(subject, "Adam Warner [New York]");
        // 订阅主题
        observer.subscribe();
        System.out.println();

        // 新建一个名为“Tim Ronney”的观察者
        Observer observer2 = new SMSUser(subject, "Tim Ronney [London]");
        // 订阅主题
        observer2.subscribe();

        // 此时足球赛事解说开始评论，该评论会实时更新到以上名为为“Tim Ronney”和“Adam Warner”的观察者
        Commentary cObject = ((Commentary)subject);
        cObject.setCommentary("Welcome to live Soccer match");
        cObject.setCommentary("Current score 0-0");
        System.out.println();

        // 名为“Tim Ronney”的观察者取消订阅，那么接下来相关主题信息不会推送给他
        observer2.unSubcribe();
        System.out.println();

        // 此时足球赛事解说又开始评论，该评论此时只会实时更新到名为“Tim Ronney”的观察者
        cObject.setCommentary("It’s a goal!!");
        cObject.setCommentary("Current score 1-0");
        System.out.println();

        // 此时又加入了一个名为Marrie的观察者
        Observer observer3 = new SMSUser(subject, "Marrie [Paris]");
        observer3.subscribe();
        System.out.println();
        // 此时足球赛事解说又开始评论，该评论此时会推送给名为“Adam Warner”和“Marrie”的观察者
        cObject.setCommentary("It’s another goal!!");
        cObject.setCommentary("Half-time score 2-0");
    }
}
