export class DonutChartModel {

    //Fields 
    isActive: boolean
    country: String
    dob: Date
    email:String
    userId:Number


    
    constructor ( isActive: boolean,  country: String, dob: Date,email:String, userId:Number){
       this.isActive = isActive
       this.country = country
       this.dob=dob
       this.email=email
       this.userId=userId
    }

}