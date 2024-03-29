package com.example.blogger.comments;

import com.example.blogger.articles.ArticleEntity;
import com.example.blogger.common.BaseEntity;
import com.example.blogger.users.UserEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "comments")
public class CommentEntity extends BaseEntity {
	private String title;

	@Column(nullable = false)
	@NonNull
	private String body;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity author;

	@ManyToOne
	@JoinColumn(name = "article_id")
	private ArticleEntity article;
}