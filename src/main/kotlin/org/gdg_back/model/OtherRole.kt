package org.gdg_back.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "other_roles")
class OtherRole(
    @Id
    @Column(name = "role_id", updatable = false, nullable = false)
    val id: UUID = UUID.randomUUID(),

    @Column(name = "role_name")
    val roleName: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    val person: BasicInfo
){}
