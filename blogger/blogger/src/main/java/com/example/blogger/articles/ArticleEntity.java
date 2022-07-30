package com.example.blogger.articles;

import com.example.blogger.common.BaseEntity;
import com.example.blogger.users.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "articles")
public class ArticleEntity extends BaseEntity {


	@Column(nullable = false)
	@NonNull
	private String heading;

	@Column(nullable = false)
	@NonNull
	private String subheading;

	@Column(nullable = false)
	@NonNull
	private String slug;

	@Column(nullable = false)
	@NonNull
	private String content;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity author;
	// private List<String> tags;
}