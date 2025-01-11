package org.gdg_back.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "personal_info")
class PersonalInfo(
    @Id @GeneratedValue(generator = "UUID")
    @Column(name = "personal_id", updatable = false, nullable = false)
    val id: UUID = UUID.randomUUID(),

    @Column(columnDefinition = "text")
    val education: String? = null,

    @Column(columnDefinition = "text")
    val background: String? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    val person: BasicInfo
){

}