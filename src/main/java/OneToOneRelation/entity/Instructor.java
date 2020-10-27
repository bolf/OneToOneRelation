package OneToOneRelation.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id") //prevents circular serialization
@Table(name="instructors")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String lastname;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	public Instructor() {}
		
	public Instructor(String name, String lastname, InstructorDetail instructorDetail) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.instructorDetail = instructorDetail;
	}

	@Override
	public String toString() {
		return "Instructor{" +
				"id=" + id +
				", name='" + name + '\'' +
				", lastname='" + lastname + '\'' +
				", instructorDetail.hobby=" + instructorDetail.getHobby() +
				'}';
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
