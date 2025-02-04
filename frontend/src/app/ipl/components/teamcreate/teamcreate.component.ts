import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Team } from "../../types/Team";
import { IplService } from "../../services/ipl.service";
import { HttpErrorResponse } from "@angular/common/http";

@Component({
  selector: 'app-teamcreate',
  templateUrl: './teamcreate.component.html',
  styleUrls: ['./teamcreate.component.scss'] 
})

export class TeamCreateComponent implements OnInit {

  teamForm !: FormGroup<any>;
  successMessage: string | null;
  errorMessage: string | null;
  currentYear : number = new Date().getFullYear();
  team : Team | null = null;

  constructor(private fb: FormBuilder , private iplService : IplService) {}

  ngOnInit(): void {
    this.teamForm = this.fb.group({
      //teamId: [null, [Validators.required, Validators.minLength(1)]],
      teamName: ['', [Validators.required,Validators.pattern(/^[a-zA-Z0-9]+$/)]],
      location: ['', Validators.required],
      ownerName: ['', [Validators.required, Validators.minLength(2)]],
      establishmentYear: [null, [Validators.required, Validators.min(1900) , Validators.max(this.currentYear)]]
    });
  }

  onSubmit(): void {
    this.addTeam();
  }

  private addTeam() : void {
    if(this.teamForm.valid) {
      this.iplService.addTeam(this.teamForm.value).subscribe({
        next : (response:Team) =>{
          this.team = response;
          this.successMessage = 'Team created successfully!';
          this.errorMessage = null;
          this.teamForm.reset;
        },
        error : () => {
          this.errorMessage = 'Please fill out all required fields correctly.';
          this.successMessage = null;
        }
      })
  }
}



  resetForm(): void {
    this.teamForm.reset({
      teamId: null,
      teamName: '',
      location: '',
      ownerName: '',
      establishmentYear: this.currentYear
    });
  }

  private handleError(error : HttpErrorResponse) : void {
    if(error.error instanceof ErrorEvent) {
      this.errorMessage = `Client-side error: ${error.error.message}`;
    }
    else{
      this.errorMessage = `Server-side error: ${error.status} ${error.message}`;
      if(error.status === 400){
        this.errorMessage = 'Bad request. Please check your input.';
      }
    }
    this.successMessage = 'Team created successfully!';
    
    console.error('An error occurred:' , this.errorMessage);

  }
}
