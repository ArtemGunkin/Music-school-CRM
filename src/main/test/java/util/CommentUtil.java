package util;

import ru.kpfu.itis.gunkin.entities.Comment;
import ru.kpfu.itis.gunkin.entities.News;
import ru.kpfu.itis.gunkin.entities.User;

import java.util.Date;

public class CommentUtil {
    public static Comment createComment(News news, User user){
        return new Comment("Comment content", user, news, new Date());
    }
}
